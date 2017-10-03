package com.appController;

import com.em.GradeEnum;
import com.entity.UserDO;
import com.service.UserService;
import com.util.JsonConvert;
import com.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sa on 2017-07-31.
 */
@Controller
@RequestMapping(value = "/xqjr/user")
public class AppUserController {

    @Autowired
    private UserService userService;

    /**
     *
     * @param userDO
     * @return (0:用户不存在 1:登录成功 2:密码有误
     */
    @RequestMapping(value = "/appUserLogin",method = RequestMethod.GET)
    @ResponseBody
    public String appUserLogin(UserDO userDO){
        userDO.setPassword(MD5Util.GetMD5Code(userDO.getPassword()));

        //如果不存在，则返回code=0
        if(!userService.IfExists(userDO))
            //
            return "0";
        else{
            UserDO userselect= userService.selectUserByPhone(userDO);
            if(userDO.getPassword().equals(userselect.getPassword())&&userDO.getPassword()!=null&&userDO.getPhone()!=null)
                //如果验证成功，则返回1
                return "1";
            else
                //如果密码不匹配，则返回2
                return "2";
        }
    }

    /**
     *
     * @param userDO
     * @return (0:用户不存在 1：验证成功 2密码不正确）
     */
    @RequestMapping(value = "/appUserCLogin",method = RequestMethod.GET)
    @ResponseBody
    public String appUserCLogin(UserDO userDO){
        userDO.setPassword(MD5Util.GetMD5Code(userDO.getPassword()));
        //如果不存在，则返回code=0
        if(!userService.IfExists(userDO))
            return "0";
        else{
            UserDO userselect= userService.selectUserByPhone(userDO);
            if(!userselect.getGrade().equals(GradeEnum.C.code()))
                return "0";
            if(userDO.getPassword().equals(userselect.getPassword())&&userDO.getPassword()!=null&&userDO.getPhone()!=null)
                //如果验证成功，则返回1
                return "1";
            else
                //如果密码不匹配，则返回2
                return "2";
        }
    }

    /**
     *
     * @param userDO
     * @return (0:用户不存在 1：验证成功 2密码不正确）
     */
    @RequestMapping(value = "/appUserABLogin",method = RequestMethod.GET)
    @ResponseBody
    public String appUserABLogin(UserDO userDO){
        userDO.setPassword(MD5Util.GetMD5Code(userDO.getPassword()));
        //如果不存在，则返回code=0
        if(!userService.IfExists(userDO))
            return "0";
        else{
            UserDO userselect= userService.selectUserByPhone(userDO);
            if(!(userselect.getGrade().equals(GradeEnum.A.code())||userselect.getGrade().equals(GradeEnum.B.code())))
                return "0";
            if(userDO.getPassword().equals(userselect.getPassword())&&userDO.getPassword()!=null&&userDO.getPhone()!=null)
                //如果验证成功，则返回1
                return "1";
            else
                //如果密码不匹配，则返回2
                return "2";
        }
    }


    /**
     * 根据用户手机号获取用户的基本信息
     * @param phone（用户手机号）
     * @return
     */
    @RequestMapping(value = "/appGetUserByPhone",method = RequestMethod.GET)
    @ResponseBody
    public UserDO appGetUserByPhone(String phone){
        UserDO userDO = new UserDO();
        userDO.setPhone(phone);
        UserDO userDOReturn = userService.selectUserByPhone(userDO);
        return userDOReturn;
    }

    /**
     * 根据userid更新用户信息
     * @param jsonUser(UserDO的json串）
     * @return（0：空串 1：更新成功 2：更新失败）
     */
    @ResponseBody
    @RequestMapping(value = "/appUserUpdateByUserId",method = RequestMethod.POST)
    public String appUserUpdateByUserId(String jsonUser){
        System.out.println("jsonUser="+jsonUser);
        if(jsonUser.equals("")||jsonUser.length()==0||jsonUser==null)
            return "0";
        UserDO userDO= JsonConvert.jsonToObject(jsonUser,UserDO.class);
        if(userService.update(userDO))
            return "1";
        return "2";
    }

    /**
     *
     * @param phone
     * @param password
     * @return 1:注册成功  0：注册异常（可能是推荐人手机号被篡改） 4：数据库注册异常  2：用户已注册
     */
    @ResponseBody
    @RequestMapping(value = "/appUserRegister",method = RequestMethod.GET)
    public String  appUserRegister(String phone,String password){
        if(phone==null||phone.length()!=11||password==null)
            return "2";
        //采用md5加密
        password= MD5Util.GetMD5Code(password);
        return userService.userInsertByApp(phone,password);
    }

    /**
     *
     * @param phone
     * @param password
     * @return  0:用户不存在 1：修改密码成功 2：数据库密码更新异常
     */
    @ResponseBody
    @RequestMapping(value = "/appUserPwdModify",method = RequestMethod.GET)
    public String appUserPwdModify(String phone,String password){
        if(phone==null||phone.length()!=11||password==null)
            return "0";
        //如果用户存在，则修改密码
        if(userService.IfExistsByPhone(phone)){
            //采用md5加密
            password= MD5Util.GetMD5Code(password);
            UserDO userDO = new UserDO();
            userDO.setPhone(phone);
            userDO.setPassword(password);
            if(userService.updateByPhone(userDO))
                return "1";
            else
                return "2";
        }else{
            return "0";
        }
    }



}
