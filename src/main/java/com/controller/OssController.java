package com.controller;

import com.oss.StsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sa on 2017-08-18.
 */
@Controller
@RequestMapping(value = "/xqjr")
public class OssController {


    private StsService stsService;

    @RequestMapping(value = "/ossSts")
    @ResponseBody
    public Map ossSts(){
        Map map = new HashMap();
        map=StsService.getSts();
        return map;
    }

}
