package com.controller;

import com.service.UserService;
import com.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by sa on 2017-09-04.
 */
@Controller
@RequestMapping(value = "/sms/")
public class SendSMSController{

    @Autowired
    private UserService userService;

    /**
     * 验证码发送
     * @param phone
     * @return（1：发送成功 2：发送失败 3：手机号已存在）
     */
    @RequestMapping(value = "/sendSMS",method = RequestMethod.POST)
    @ResponseBody
    public String sendSMS(String phone, HttpSession session){
        System.out.println("验证="+phone);
        if(userService.IfExistsByPhone(phone))
            return "3";
        String cellcode= SmsUtil.post(phone);
        session.setAttribute("cellphone",phone);
        session.setAttribute("cellcode",cellcode);
        return "1";
    }

}
