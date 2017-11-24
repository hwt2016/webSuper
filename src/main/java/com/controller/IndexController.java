package com.controller;

import com.alibaba.druid.util.StringUtils;
import com.entity.AdminDO;
import com.entity.UserDO;
import com.service.AdminService;
import com.service.AscriptionService;
import com.service.UserIncomeService;
import com.service.UserService;
import com.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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

    @Autowired
    private AdminService adminService;

    //获取登录界面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        //TODO 后期需要修改
        return "admin/login";
    }


    //登录跳转
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(AdminDO adminDO, ModelMap modelMap,HttpSession session){
        if(StringUtils.isEmpty(adminDO.getAdminname())){

            return "admin/login";
        }
        if(adminService.ifExists(adminDO)){
            AdminDO adminDOselect = adminService.selectAdminByAdminName(adminDO.getAdminname());
            if (adminDOselect.getPassword().equals(adminDO.getPassword())&&adminDO.getPassword().length()!=0){
                return "admin/index";
            }
        }
        return "admin/login";
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
     * 注册C
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

        //验证用户是否存在
        if(userService.IfExistsByPhone(phone))
            return "2";//新用户已注册

        String cellphone=session.getAttribute("cellphone").toString();
        String cellcode = session.getAttribute("cellcode").toString();
        //手机验证码不正确返回3
        if(!(cellphone.equals(phone)&&cellcode.equals(code)))
            return "3";

        //如果返回值为1：注册成功   0：注册异常   2：用户已注册
        return userService.userInitByInvite(phone,MD5Util.GetMD5Code(password),recommendPhone);

    }


    @RequestMapping(value = "/registerBByInvite",method = RequestMethod.GET)
    public String registerBByInvite(String recommendPhone, ModelMap modelMap){
        if(recommendPhone==null||recommendPhone.length()!=11)
            return "status/error";
        if(userService.IfExistsByPhone(recommendPhone)){
            //将上级的phone存到modelMap中
            modelMap.addAttribute("recommendPhone",recommendPhone);
            return "user/registerB";
        }
        return "error";
    }

    /**
     * 注册B
     * @param phone 手机号
     * @param password 密码
     * @return（0：注册异常 1:注册成功 2：手机已注册 3：手机验证码不正确
     */
    @ResponseBody
    @RequestMapping(value = "/registerBByInvite",method = RequestMethod.POST)
    public String registerBByInvite(String phone,String password,String recommendPhone,String code,HttpSession session){
        //推荐人填写错误 返回0
        if(recommendPhone.equals("")||recommendPhone==null||phone.equals("")||phone==null)
            return "0";

        //验证用户是否存在
        if(userService.IfExistsByPhone(phone))
            return "2";//新用户已注册

        String cellphone=session.getAttribute("cellphone").toString();
        String cellcode = session.getAttribute("cellcode").toString();
        //手机验证码不正确返回3
        if(!(cellphone.equals(phone)&&cellcode.equals(code)))
            return "3";

        //如果返回值为1：注册成功   0：注册异常   2：用户已注册
        return userService.userInitBByInvite(phone, MD5Util.GetMD5Code(password),recommendPhone);

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
