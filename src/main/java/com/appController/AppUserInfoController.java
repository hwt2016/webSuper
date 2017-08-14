package com.appController;

import com.entity.UserInfoDO;
import com.service.UserInfoService;
import com.util.JsonConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户详细信息表
 * Created by sa on 2017-08-05.
 */
@Controller
@RequestMapping(value = "/xqjr/userInfo")
public class AppUserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    /**
     *根据用户id获取用户的相信信息
     * @param userid(用户id)
     * @return(该用户的详细信息）
     */
    @ResponseBody
    @RequestMapping(value = "/appUserInfoGetByUserId")
    private UserInfoDO appUserInfoGetByUserId(Integer userid){
        UserInfoDO userInfoDO = userInfoService.selectUserInfoByUserId(userid);
        return userInfoDO;
    }

    /**
     * 根据userId更新用户的详细信息
     * @param jsonUserInfo
     * @return（0：空串 1：更新成功 2：更新失败）
     */
    @ResponseBody
    @RequestMapping(value = "/appUserInfoUpdateByUserId",method = RequestMethod.POST)
    private String appUserInfoUpdateByUserId(String jsonUserInfo){
        //如果接收的字符串为空，则返回0
        if(jsonUserInfo==null||jsonUserInfo.equals(""))
            return "0";
        //将jsonUserInfo转换成UserInfoDO
        UserInfoDO userInfoDO= JsonConvert.jsonToObject(jsonUserInfo,UserInfoDO.class);
        if(userInfoService.updateByUserId(userInfoDO))
            return "1";
        return "2";
    }

}
