package com.controller;

import com.entity.UserDO;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hwt on 2017/5/25.
 */
@Controller
public class IndexController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        UserDO userDO=new UserDO();
        userDO.setPhone("123");
        userDO.setPassword("123");
        userService.insert(userDO);

        return "yes";
    }
}
