package com.controller;

import com.convert.DateConvert;
import com.entity.UserInfoDO;
import com.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by sa on 2017-06-14.
 * 与userinfo用户详细信息表相关的操作
 * 新增、更新、删除、查询
 */
@Controller
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    //更新用户详细信息
    @RequestMapping(value = "/userInfoModify")
    public String userInfoModify(ModelMap modelMap, int userInfoId){
        //根据userInfoId提取用户详细信息
        UserInfoDO userInfoDO = userInfoService.selectUserInfoById(userInfoId);
        //定义两个字符串变量date_startofwork，date_hiredate，他们在数据库存储的是2017/06/15 17:20:20这种格式
        // 现在需要把他们转换成2017/06/15这种util.date.sql格式，方便在页面上显示
        String date_startofwork=null,date_hiredate=null;
        //将日期转换成字符串
        if(userInfoDO.getStartofwork()!=null)
            date_startofwork= DateConvert.dateToStr(userInfoDO.getStartofwork());
        //将日期转换成字符串
        if(userInfoDO.getHiredate()!=null)
            date_hiredate= DateConvert.dateToStr(userInfoDO.getHiredate());
        //注入变量
        modelMap.addAttribute("userinfo",userInfoDO);
        modelMap.addAttribute("date_startofwork",date_startofwork);
        modelMap.addAttribute("date_hiredate",date_hiredate);
        return "user/perInfo/userInfoModify";
    }

    //更新用户详细信息
    @RequestMapping(value = "/userInfoModify",method = RequestMethod.POST)
    @ResponseBody
    public String userInfoModify(UserInfoDO userInfoDO,String date_startofwork,String date_hiredate){
        //将时间字符串转换成日期类型
        Date startofwork = DateConvert.strToDate(date_startofwork);
        //将时间字符串转换成日期类型
        Date hiredate = DateConvert.strToDate(date_hiredate);
        //设置开始工作时间
        userInfoDO.setStartofwork(startofwork);
        //设置入职时间
        userInfoDO.setHiredate(hiredate);
        //设置更新时间
        userInfoDO.setUpdatetime(new Date(System.currentTimeMillis()));
        if(userInfoService.update(userInfoDO))
            return "true";
        else
            return "录入失败";
    }


}
