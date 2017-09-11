package com.controller;

import com.constant.Constant;
import com.em.GradeEnum;
import com.entity.AdminDO;
import com.entity.AscriptionDO;
import com.entity.UserDO;
import com.entity.UserIncomeDO;
import com.google.zxing.WriterException;
import com.oss.PostObject;
import com.service.AscriptionService;
import com.service.UserIncomeService;
import com.service.UserService;
import com.util.ZxingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by hwt on 2017/5/25.
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {


    @Autowired
    private UserService userService;

    @Autowired
    private AscriptionService ascriptionService;

    @Autowired
    private UserIncomeService userIncomeService;

    //获取登录界面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        //TODO 后期需要修改
        return "admin/login";
    }


    //登录跳转
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(AdminDO adminDO, ModelMap modelMap,HttpSession session){
        //TODO 后期需要修改
        System.out.println("adminName:"+adminDO.getAdminname()+"  password:"+adminDO.getPassword()+"1234");
        return "admin/index";
    }

    /**
     * 邀请链接
     * @param recommendPhone
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/registerByInvite")
    public String  registerByInvite(String recommendPhone,ModelMap modelMap){
        if(recommendPhone.equals("")||recommendPhone==null)
            return "status/error";
        UserDO user = new UserDO();
        user.setPhone(recommendPhone);
        if (userService.IfExists(user)){
            modelMap.addAttribute("recommendPhone",recommendPhone);
            return "user/registerByInvite";
        }
        return "status/error";
    }

    /**
     * 注册//TODO 少了一步验证码
     * @param phone 手机号
     * @param password 密码
     * @return（0：注册异常 1:注册成功 2：手机已注册 3：手机验证码不正确
     */
    @ResponseBody
    @RequestMapping(value = "/registerByInvite",method = RequestMethod.POST)
    public String registerByInvite(String phone,String password,String recommendPhone,String code,HttpSession session){
        //推荐人填写错误 返回0
        if(recommendPhone.equals("")||recommendPhone==null||phone.equals("")||phone==null)
            return "0";
        String cellphone=session.getAttribute("cellphone").toString();
        String cellcode = session.getAttribute("cellcode").toString();
        //手机验证码不正确返回3
        if(!(cellphone.equals(phone)&&cellcode.equals(code)))
            return "3";

        UserDO userRecommend =new UserDO();
        userRecommend.setPhone(recommendPhone);
        if(userService.IfExists(userRecommend)){
            UserDO userDO=new UserDO();
            userDO.setPhone(phone);
            userDO.setPassword(password);
            userDO.setStatus("正常");
            userDO.setGrade(GradeEnum.C.code());
            if(userService.IfExists(userDO))
                return "2";//新用户已注册
            //生成二维码，并上传到阿里OSS上
            try {
                //上传到OSS地址
                String key="user/"+userDO.getPhone()+"/qrcode.png";
                //生成二维码本地路径
                String qrcodePath=Constant.USER_LOCAL_DIR+userDO.getPhone()+".png";
                //生成二维码
                ZxingUtil.createQRCode(Constant.INVITE+userDO.getPhone(), new File(qrcodePath));
                //上传到OSS
                PostObject ossPostObject = new PostObject();
                ossPostObject.post(key,qrcodePath);
                //更新新用户的邀请链接
                userDO.setInvitelink(Constant.HOST_USER+userDO.getPhone()+"/qrcode.png");
            } catch (WriterException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(userService.insert(userDO)){

                userDO=userService.selectUserByPhoneNum(userDO.getPhone());
                userRecommend=userService.selectUserByPhone(userRecommend);

                System.out.println("新用户id="+userDO.getId()+"推荐人id:"+userRecommend.getId());
                //初始化该用户的收入表
                UserIncomeDO userIncomeDO = new UserIncomeDO();
                userIncomeDO.setUserid(userDO.getId());
                userIncomeDO.setStatus("正常");
                userIncomeDO.setIncome(0.0);
                userIncomeDO.setUpincome(0.0);
                userIncomeService.insert(userIncomeDO);
                //如果推荐人的等级为C
                if(userRecommend.getGrade().equals(GradeEnum.C.code())){
                    //提取推荐人（M)归属关系信息
                    AscriptionDO ascriptionDO =ascriptionService.selectBydownGradeUserId(userRecommend.getId());
                    //定义一个上级变量
                    UserDO upGradeUser = new UserDO();
                    //若果有上级则提取用户（M)的上级用户信息（N)
                    if(ascriptionDO!=null){
                        //TODO 后期需要添加推荐人的奖励
                        upGradeUser = userService.selectUserById(ascriptionDO.getUpuserid());
                        //设置归属关系
                        AscriptionDO ascriptionDONew=new AscriptionDO();
                        //设置新用户上级id
                        ascriptionDONew.setUpuserid(upGradeUser.getId());
                        //设置新用户id
                        ascriptionDONew.setDownuserid(userDO.getId());
                        //设置新用户上级等级
                        ascriptionDONew.setUpgrade(upGradeUser.getGrade());
                        //设置新用户等级
                        ascriptionDONew.setDowngrade(GradeEnum.C.code());
                        ascriptionDONew.setStatus("正常");
                        ascriptionService.insert(ascriptionDONew);
                    }
                }
                else {
                    AscriptionDO ascriptionDONew=new AscriptionDO();
                    ascriptionDONew.setUpuserid(userRecommend.getId());
                    ascriptionDONew.setDownuserid(userDO.getId());
                    ascriptionDONew.setUpgrade(userRecommend.getGrade());
                    ascriptionDONew.setDowngrade(GradeEnum.C.code());
                    ascriptionDONew.setStatus("正常");
                    ascriptionService.insert(ascriptionDONew);
                }
                return "1";//注册成功
            }

        }
        return "0";//注册异常（可能是推荐人手机号被篡改）
    }

    //欢迎界面
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(){

        return "admin/welcome";
    }

    //欢迎界面
    @RequestMapping(value = "/appDownload",method = RequestMethod.GET)
    public String appDownload(){

        return "user/appDownload";
    }




}
