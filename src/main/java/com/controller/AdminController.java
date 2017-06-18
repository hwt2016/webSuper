package com.controller;

import com.entity.AdminDO;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sa on 2017-05-31.
 * 操作与Admin（管理员表）相关的操作
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //获取密码修改界面
    @RequestMapping(value = "/codeModify",method = RequestMethod.GET)
    public String codeModify(){
        //TODO 需要修改
        return "admin/codeModify";
    }





    //********************************************接口************************************************************

    //密码修改
    @RequestMapping(value = "/codeModify",method = RequestMethod.POST)
    @ResponseBody
    public String codeModify(String password){
        //TODO 需要修改
        System.out.println("password="+password);
        AdminDO adminDO = new AdminDO();
        adminDO.setId(1);
        adminDO.setPassword("1234");
        if(adminService.codeModify(adminDO))
            return "更新成功";
        else
            return "更新失败";
    }
}
