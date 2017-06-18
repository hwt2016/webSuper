package com.controller;

import com.em.StatusEnum;
import com.entity.HouseDO;
import com.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by sa on 2017-06-14.
 * 跟House房产表操作相关的操作
 * 新增、更新、删除、查询
 */
@Controller
@RequestMapping(value = "/house")
public class HouseController {


    @Autowired
    private HouseService houseService;


    //更新房屋信息
    @RequestMapping(value = "/userHouseModify")
    public String userHouseModify(ModelMap modelMap, int houseid){
        //根据houseid提取房屋信息
        HouseDO houseDO = houseService.selectHouseById(houseid);
        modelMap.addAttribute("house",houseDO);
        return "user/perInfo/userHouseModify";
    }

    //更新房屋信息
    //参数说明：根据id,更新houseDo中不为null的数据
    @RequestMapping(value = "/userHouseModify",method = RequestMethod.POST)
    @ResponseBody
    public String userHouseModify(HouseDO houseDO){
        //设置更新时间
        houseDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //判断是否更新成功
        if(houseService.update(houseDO))
            return "true";
        else
            return "录入失败";
    }

    //根据用户id新增房产信息
    @RequestMapping(value = "/userHouseAdd")
    public String userHouseAdd(ModelMap modelMap,int userid){
        modelMap.addAttribute("userid",userid);
        return "user/perInfo/userHouseAdd";
    }

    //根据用户id新增房产信息
    //参数为houseDO中除了id，status,createtime,updatetime中数据
    @RequestMapping(value = "/userHouseAdd",method = RequestMethod.POST)
    @ResponseBody
    public String userHouseAdd(HouseDO houseDO){
        //设置创建时间
        houseDO.setCreatetime(new Date(System.currentTimeMillis()));
        //设置更新时间
        houseDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //设置状态为正常
        houseDO.setStatus(StatusEnum.NORMAL.code());
        if(houseService.insert(houseDO))
            return "true";
        else
            return "新增房产失败";
    }


}
