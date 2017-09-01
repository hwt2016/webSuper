package com.appController;

import com.util.SmsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sa on 2017-08-31.
 */
@Controller
@RequestMapping(value = "xqjr/sms")
public class AppSmsController {

    @RequestMapping(value = "/appSmsPost")
    @ResponseBody
    public String appSmsPost(String phone){
        String code = SmsUtil.post(phone);
        return code;
    }
}
