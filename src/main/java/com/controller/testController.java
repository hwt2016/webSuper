package com.controller;

import com.entity.UserDO;
import com.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sa on 2017-05-25.
 */
@Controller
@RequestMapping(value = "/test")
public class testController {
    @Autowired
    private UserService userService;



//    @RequestMapping(value = "/appUserLogin",method = RequestMethod.POST)
//    @ResponseBody
//    public String test(String username,String password){
//        System.out.println("username="+username);
//        return "true";
//    }

    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("userid",21);
        return "test/index";
    }



    @RequestMapping(value = "/appUserLogin",method = RequestMethod.GET)
    @ResponseBody
    public String test(UserDO userDO){
        System.out.println("username="+userDO.getPhone()+userDO.getPassword());

        if(userDO.getPhone().equals("123")&&userDO.getPassword().equals("123"))
            return "true";
        else
            return "false";
    }

    @RequestMapping(value = "/jsontest",method = RequestMethod.GET)
    @ResponseBody
    public String jsontest(){
        List<Map> list = new ArrayList<Map>();
        Map aqMap = new HashMap();
        Map bqMap = new HashMap();
        Map cqMap = new HashMap();
        Map dqMap = new HashMap();


        cqMap.put("name","c");
        cqMap.put("size",3600);
        bqMap.put("name","bbdf");
        bqMap.put("size",3938);
        list.add(bqMap);
        aqMap.put("name","a");
        aqMap.put("children",list);



        String resultStr= JSONObject.fromObject(aqMap).toString();//要返回的参数字符串

      //  String rs="{\"name\": \"flare\",\"children\": [{\"name\": \"analytics\",\"children\": [{\"name\": \"cluster\",\"children\": [{\"name\": \"AgglomerativeCluster\",\"size\": 3938}]}]}]}";
      // String rs = "{\"name\": \"flare\",\"children\": [{\"name\": \"analytics\",\"children\": [{\"name\": \"cluster\",\"size\": 3938}]}]}";
        String rs="{\"name\": \"flare\",\"children\": [{\"name\": \"analytics\",\"size\": 3938}]}";
        System.out.println(rs);
        System.out.println(resultStr);
        return resultStr;
    }
}
