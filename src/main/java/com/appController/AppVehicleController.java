package com.appController;

import com.entity.VehicleDO;
import com.service.VehicleService;
import com.util.JsonConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by sa on 2017-08-01.
 */
@Controller
@RequestMapping(value = "/xqjr/vehicle")
public class AppVehicleController {

    @Autowired
    private VehicleService vehicleService;

    /**
     * 根据用户id提取用户所有的车辆信息
     * @param userid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/appVehicleGetByUserId",method = RequestMethod.GET)
    public List<VehicleDO> appVehicleGetByUserId(Integer userid){
        List<VehicleDO> vehicleDOList = vehicleService.selectVehiclesByUserid(userid);
        return vehicleDOList;
    }

    /**
     *更新或添加车辆信息
     * @param jsonVehicle（待更新的车辆列表）
     * @return（0：待更新的车辆列表为空 1：更新或添加成功 2:更新失败）
     */
    @ResponseBody
    @RequestMapping(value = "/appVehicleUpdateAll",method = RequestMethod.POST)
    public String appVehicleUpdateAll(String jsonVehicle){
        if(jsonVehicle==null||jsonVehicle.equals(""))
            return "0";
        List<VehicleDO> vehicleDOArrayList= null;
        try {
            vehicleDOArrayList = JsonConvert.jsonToObjectList(jsonVehicle,VehicleDO.class);
            for(VehicleDO vehicleDO:vehicleDOArrayList){
                if(vehicleDO.getId()==null||vehicleDO.getId().equals(""))
                    vehicleService.insert(vehicleDO);
                else
                    vehicleService.update(vehicleDO);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "2";
        }

        return "1";
    }

}
