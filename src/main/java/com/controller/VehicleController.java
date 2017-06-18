package com.controller;

import com.em.StatusEnum;
import com.entity.VehicleDO;
import com.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by sa on 2017-06-14.
 * 与vehicle车辆表相关的操作
 * 新增、更新、删除、查询等
 */
@Controller
@RequestMapping(value = "/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    //更新车辆信息
    @RequestMapping(value = "/userVehicleModify")
    public String userVehicleModify(ModelMap modelMap, int vehicleid){
        //根据车辆id提取车辆信息
        VehicleDO vehicleDO = vehicleService.selectVehicleById(vehicleid);
        //注入车辆信息
        modelMap.addAttribute("vehicle",vehicleDO);
        return "user/perInfo/userVehicleModify";
    }

    //更新车辆信息
    //参数说明 userid(用户ID),typeOfCar(车型），natureOfVehicle（汽车性质），fullCar（是否全款），mortgage（是否按揭）
    @RequestMapping(value = "/userVehicleModify",method = RequestMethod.POST)
    @ResponseBody
    public String userVehicleModify(VehicleDO vehicleDO){
        vehicleDO.setUpdatetime(new Date(System.currentTimeMillis()));
        if(vehicleService.update(vehicleDO))
            return "true";
        else
            return "录入失败";
    }

    //根据用户id新增车辆
    @RequestMapping(value = "/userVehicleAdd")
    public String userVehicleAdd(ModelMap modelMap,int userid){
        modelMap.addAttribute("userid",userid);
        return "user/perInfo/userVehicleAdd";

    }
    //根据用户id新增车辆
    @RequestMapping(value = "/userVehicleAdd",method = RequestMethod.POST)
    @ResponseBody
    public String userVehicleAdd(VehicleDO vehicleDO){
        //设置创建时间
        vehicleDO.setCreatetime(new Date(System.currentTimeMillis()));
        //设置更新时间
        vehicleDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //设置状态为正常
        vehicleDO.setStatus(StatusEnum.NORMAL.code());
        if(vehicleService.insert(vehicleDO))
            return "true";
        else
            return "新增车辆失败";
    }


}
