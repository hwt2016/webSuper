package com.controller;

import com.entity.AdminDO;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by hwt on 2017/5/25.
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {


    @Autowired
    private UserService userService;

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

    //欢迎界面
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(){

        return "admin/welcome";
    }



}
