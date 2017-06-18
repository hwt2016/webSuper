package com.controller;

import com.convert.GradeConvert;
import com.em.GradeEnum;
import com.em.StatusEnum;
import com.entity.AscriptionDO;
import com.entity.UserDO;
import com.service.AscriptionService;
import com.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by sa on 2017-06-08.
 */
@Controller
@RequestMapping(value = "/ascription")
public class AscriptionController {

    @Autowired
    UserService userService;

    @Autowired
    AscriptionService ascriptionService;

    //关系调整主界面
    @RequestMapping(value = "/mainAsc")
    public String mainView(){
        return "user/perAsc/mainAsc";
    }


    //搜索，根据手机号搜索用户所有信息
    //参数说明 ：phone 表示用户表的手机号
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String search(String phone, ModelMap modelMap){
        UserDO userDO = new UserDO();
        //根据手机号提取用户信息
        userDO.setPhone(phone);
        //判断手机号是否存在
        if(!userService.IfExists(userDO))
            return "user/perAsc/errorPhone";
        //通过手机号提取待调动的用户信息(假定为M用户）
        UserDO ownUser= userService.selectUserByPhone(userDO);
        //提取待调动的用户（M)归属关系信息
        AscriptionDO ascriptionDO =ascriptionService.selectBydownGradeUserId(ownUser.getId());
        //定义一个上级变量
        UserDO upGradeUser = new UserDO();
        //若果有上级则提取用户（M)的上级用户信息（N)
        if(ascriptionDO!=null)
           upGradeUser = userService.selectUserById(ascriptionDO.getUpuserid());
        //提取带调动的用户（M)所有下级用户信息列表（Z)
        List<AscriptionDO> ascriptionDOS = ascriptionService.selectByupGradeUserId(ownUser.getId());
        //待存储下级用户信息列表
        List<UserDO> downGradeUserDOS =  new ArrayList<UserDO>();
        //如果为空则跳过
        if(ascriptionDOS!=null){
            for(AscriptionDO asc :ascriptionDOS){
                //根据下级downuserid提取用户信息
                UserDO user = userService.selectUserById(asc.getDownuserid());
                //加入到夏季用户信息列表中
                downGradeUserDOS.add(user);
            }
        }
        //待调动用户信息
        modelMap.addAttribute("ownUser",ownUser);
        //待调动用户的上级用户信息
        modelMap.addAttribute("upGradeUser",upGradeUser);
        //待调动用户的下级用户信息
        modelMap.addAttribute("downGradeUserDOS",downGradeUserDOS);
        //被查询的手机号
        modelMap.addAttribute("searchPhone",phone);
        return "user/perAsc/mainAsc";
    }


    //获取升级调动界面
    @RequestMapping(value = "/userUpGrade")
    public String userUpGrade(ModelMap modelMap,int userid){
        System.out.println("userid="+userid);
        //根据用户id提取用户（M)基本信息
        UserDO ownUser= userService.selectUserById(userid);
        //如果是C级用户升级，则需要添加新的上级信息
        if(ownUser.getGrade().equals(GradeEnum.C.code())){
            //提取用户（M)的上级用户信息
            List<UserDO> userDOS = userService.selectPositonOfWhich(GradeEnum.A.code());
            //注入用户信息
            modelMap.addAttribute("upGradeUsers",userDOS);
        }
        modelMap.addAttribute("ownUser",ownUser);
        return "user/perAsc/userUpGrade";
    }

    /*进行升级操作
    *参数userid(用户ID),upphone(用户的上级手机号）
    */
    @RequestMapping(value = "/userUpGrade",method = RequestMethod.POST)
    @ResponseBody
    public String userUpGrade(int userid,String upphone){
        //根据用户id提取用户（M)基本信息
        UserDO ownUser= userService.selectUserById(userid);
        //如果是C级用户升级
        if(ownUser.getGrade().equals(GradeEnum.C.code())){
            //获取归属信息对象
            AscriptionDO ascriptionDO = ascriptionService.selectBydownGradeUserId(ownUser.getId());
            //更新用户等级
            ownUser.setGrade(GradeConvert.upGrade(ownUser.getGrade()));
            //更新用户信息表
            if(!userService.update(ownUser))
                return "用户信息更新失败";
            //根据手机号获取上级用户信息
            UserDO upUser =userService.selectUserByPhoneNum(upphone);
            //设置上级userid
            ascriptionDO.setUpuserid(upUser.getId());
            //设置上级等级
            ascriptionDO.setUpgrade(upUser.getGrade());
            //更新该用户等级
            ascriptionDO.setDowngrade(ownUser.getGrade());
            //更新归属关系对象
            if(!ascriptionService.update(ascriptionDO))
                return "等级调动失败";
        }
        //如果是B级用户升级
        else  if(ownUser.getGrade().equals(GradeEnum.B.code())){
            //获取归属信息对象
            AscriptionDO ascriptionDO = ascriptionService.selectBydownGradeUserId(ownUser.getId());
            //更新用户等级
            ownUser.setGrade(GradeConvert.upGrade(ownUser.getGrade()));
            //更新用户信息表
            if(!userService.update(ownUser))
                return "用户信息更新失败";
            //更新归属关系对象
            if(!ascriptionService.delete(ascriptionDO.getId()))
                return "等级调动失败";

        }
        return "true";
    }


    //获取降级调动界面
    //参数说明 ：userid 表示用户表的id
    @RequestMapping(value = "/userDownGrade")
    public String userDownGrade(ModelMap modelMap,int userid){
        //根据用户id提取用户（M)基本信息
        UserDO ownUser= userService.selectUserById(userid);
        //如果是A级用户降级，则需要添加新的上级信息
        if(ownUser.getGrade().equals(GradeEnum.A.code())){
            //提取所有的上级用户信息
            List<UserDO> userDOList = userService.selectPositonOfWhich(GradeEnum.A.code());
            //待存放上级用户信息列表
            List<UserDO> userDOS = new ArrayList<UserDO>();
            //除去当前用户，把其他的所有上级用户添加到userDOS中
            for(UserDO userDO:userDOList){
                if(userDO.getId()!=userid)
                    userDOS.add(userDO);
            }
            modelMap.addAttribute("upGradeUsers",userDOS);
        }
        //如果是B级用户降级，则需要添加新的上级信息
        else if(ownUser.getGrade().equals(GradeEnum.B.code())){
            //提取所有的上级用户信息
            List<UserDO> userDOList = userService.selectPositonOfWhich(GradeEnum.B.code());
            //待存放上级用户信息列表
            List<UserDO> userDOS = new ArrayList<UserDO>();
            //除去当前用户，把其他的所有上级用户添加到userDOS中
            for(UserDO userDO:userDOList){
                if(userDO.getId()!=userid)
                    userDOS.add(userDO);
            }
            modelMap.addAttribute("upGradeUsers",userDOS);//注入上级信息
        }
        modelMap.addAttribute("ownUser",ownUser);
        return "user/perAsc/userDownGrade";
    }

    //进行降级操作
    //参数说明 ：userid 表示用户表的id，upphone用户上级手机号
    @RequestMapping(value = "/userDownGrade",method = RequestMethod.POST)
    @ResponseBody
    public String userDownGrade(int userid,String upphone){
        //根据用户id提取用户（M)基本信息
        UserDO ownUser= userService.selectUserById(userid);
        //解除该用户的所有下属关系
        ascriptionService.deleteAscsByUpGradeUserId(userid);
        //解除该用户的所有上属关系
        ascriptionService.deleteAscsByDownGradeUserId(userid);
        //更新用户等级
        ownUser.setGrade(GradeConvert.downGrade(ownUser.getGrade()));
        //更新用户信息表
        if(!userService.update(ownUser))
            return "用户信息更新失败";
        //根据手机号获取上级用户信息
        UserDO upUser =userService.selectUserByPhoneNum(upphone);
        //新建一个归属关系对象
        AscriptionDO ascriptionDO = new AscriptionDO();
        //设置上级userid
        ascriptionDO.setUpuserid(upUser.getId());
        //设置上级等级
        ascriptionDO.setUpgrade(upUser.getGrade());
        //设置下级userid
        ascriptionDO.setDownuserid(ownUser.getId());
        //更新该用户等级
        ascriptionDO.setDowngrade(ownUser.getGrade());
        //设置状态为正常
        ascriptionDO.setStatus(StatusEnum.NORMAL.code());
        //设置创建时间
        ascriptionDO.setCreatetime(new Date(System.currentTimeMillis()));
        //设置更新时间
        ascriptionDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //更新归属关系对象
        if(!ascriptionService.insert(ascriptionDO))
            return "等级调动失败";

        return "true";
    }

    //获取平级调动界面
    //参数说明 ：userid 表示用户表的id
    @RequestMapping(value = "/userSidewayGrade")
    public String userSidewayGrade(ModelMap modelMap,int userid){
        //根据用户id提取用户（M)基本信息
        UserDO ownUser= userService.selectUserById(userid);
        //获取该用户的等级
        String grade= ownUser.getGrade();
        //提取用户（M)的上级用户信息
        List<UserDO> userDOS = userService.selectPositonOfWhich(GradeConvert.upGrade(grade));
        //注入上级信息
        modelMap.addAttribute("upGradeUsers",userDOS);
        modelMap.addAttribute("ownUser",ownUser);
        return "user/perAsc/userSidewayGrade";
    }

    //平级调动操作
    //参数说明 ：userid 表示用户表的id，upphone上级用户手机号
    @RequestMapping(value = "/userSidewayGrade",method = RequestMethod.POST)
    @ResponseBody
    public String userSidewayGrade(int userid,String upphone){
        //根据用户id提取用户（M)基本信息
        UserDO ownUser= userService.selectUserById(userid);
        //根据手机号获取上级用户信息
        UserDO upUser =userService.selectUserByPhoneNum(upphone);
        //获取归属关系调整对象
        AscriptionDO ascriptionDO = ascriptionService.selectBydownGradeUserId(userid);
        //更新上级userid
        ascriptionDO.setUpuserid(upUser.getId());
        //设置更新时间
        ascriptionDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //判断是否更新成功
        if(!ascriptionService.update(ascriptionDO))
            return "更新失败";
        return "true";
    }


    //获取关系展示图
    //参数说明 ：userid 表示用户表的id
    @RequestMapping(value = "/userAscShow")
    public String userAscShow(ModelMap modelMap,int userid){
        //存入userid
        modelMap.addAttribute("userid",userid);
        return "user/perAsc/userAscShow";
    }


    //关系展示图
    //参数说明 ：userid 表示用户表的id
    @RequestMapping(value = "/userAscShowData",method = RequestMethod.GET)
    @ResponseBody
    public String ascShowData(int userid){
        //根据id提取用户基本信息
        UserDO userDO = userService.selectUserById(userid);
        //如果是A级用户,则需要提取他自己本身信息，以及他的所有下级B用户信息
        if(userDO.getGrade().equals(GradeEnum.A.code())){
            //提取带调动的用户（M)所有下级用户信息列表（Z)
            List<AscriptionDO> ascriptionDOS = ascriptionService.selectByupGradeUserId(userDO.getId());
            //存储下级用户手机信息列表
            List<Map> list = new ArrayList<Map>();
            Map aqMap= new HashMap();
            //如果归属关系为空则跳过
            if(ascriptionDOS!=null){
                for(AscriptionDO asc :ascriptionDOS){
                    //根据下级downuserid提取用户信息
                    UserDO user = userService.selectUserById(asc.getDownuserid());
                    //生成一个新的map对象
                    Map bqMap = new HashMap();
                    //（D3.js插件)存储手机信息
                    bqMap.put("name",user.getPhone());
                    //（D3.js插件)设置长度
                    bqMap.put("size",3000);
                    list.add(bqMap);
                }
            }
            //（D3.js插件)设置手机号
            aqMap.put("name",userDO.getPhone());
            //(D3.js插件)设置子队列
            aqMap.put("children",list);
            //要返回的参数字符串
            String resultStr= JSONObject.fromObject(aqMap).toString();
            return resultStr;
        }
        //如果是B级用户，则需要提取他的上级用户A,以及他的所有下级用户B
        else if(userDO.getGrade().equals(GradeEnum.B.code())){
            //提取该用户为下级时的归属关系对象
            AscriptionDO ascriptionDO =ascriptionService.selectBydownGradeUserId(userDO.getId());
            //提取该用户的上级信息
            UserDO upUser = userService.selectUserById(ascriptionDO.getUpuserid());
            //提取带调动的用户（M)所有下级用户信息列表（Z)
            List<AscriptionDO> ascriptionDOS = ascriptionService.selectByupGradeUserId(userDO.getId());
            //存储当前用户信息
            List<Map> listb = new ArrayList<Map>();
            //存储下级用户手机信息列表
            List<Map> listc = new ArrayList<Map>();
            //设置A级Map
            Map aqMap= new HashMap();
            //设置B级map
            Map bqMap= new HashMap();
            //如果为空则跳过
            if(ascriptionDOS!=null){
                for(AscriptionDO asc :ascriptionDOS){
                    //根据下级downuserid提取用户信息
                    UserDO user = userService.selectUserById(asc.getDownuserid());
                    //生成一个新的map对象
                    Map cqMap = new HashMap();
                    //（D3.js插件)存储手机信息
                    cqMap.put("name",user.getPhone());
                    //（D3.js插件)设置长度
                    cqMap.put("size",3000);
                    listc.add(cqMap);
                }
            }
            //（D3.js插件)设置手机号
            bqMap.put("name",userDO.getPhone());
            //(D3.js插件)设置子队列
            bqMap.put("children",listc);
            listb.add(bqMap);
            //（D3.js插件)设置手机号
            aqMap.put("name",upUser.getPhone());
            //(D3.js插件)设置子队列
            aqMap.put("children",listb);
            //要返回的参数字符串
            String resultStr= JSONObject.fromObject(aqMap).toString();
            return resultStr;
        }
        //如果是C级用户，直接提取它的上级用户和自己本身即可
        else if(userDO.getGrade().equals(GradeEnum.C.code())){
            //提取该用户为下级时的归属关系对象
            AscriptionDO ascriptionDO =ascriptionService.selectBydownGradeUserId(userDO.getId());
            //提取该用户的上级信息
            UserDO upUser = userService.selectUserById(ascriptionDO.getUpuserid());
            //存储当前用户信息
            List<Map> listc = new ArrayList<Map>();
            //设置B级map
            Map bqMap = new HashMap();
            //生成一个新的C级map对象
            Map cqMap = new HashMap();
            //（D3.js插件)设置手机号
            cqMap.put("name",userDO.getPhone());
            //（D3.js插件)设置长度
            cqMap.put("size",3000);
            listc.add(cqMap);
            //（D3.js插件)设置手机号
            bqMap.put("name",upUser.getPhone());
            //(D3.js插件)设置子队列
            bqMap.put("children",listc);
            //要返回的参数字符串
            String resultStr= JSONObject.fromObject(bqMap).toString();
            return resultStr;
        }
        return "null";
    }


}
