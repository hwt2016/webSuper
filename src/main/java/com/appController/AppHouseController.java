package com.appController;

import com.entity.HouseDO;
import com.service.HouseService;
import com.service.UserService;
import com.util.JsonConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by sa on 2017-08-01.
 * App端房屋
 */
@Controller
@RequestMapping(value = "/xqjr/house")
public class AppHouseController {

    @Autowired
    private HouseService houseService;
    @Autowired
    private UserService userService;

    /**
     *根据用户id获取他的所有房产信息
     * @param userid （用户id)
     * @return（房产信息列表）
     */
    @ResponseBody
    @RequestMapping(value = "/appHouseGetByUserId",method = RequestMethod.GET)
    public List<HouseDO> appHouseGetByUserId(Integer userid){
        List<HouseDO> houseDOList = houseService.selectHousesByUserid(userid);
        return houseDOList;
    }

    /**
     *更新或添加房产信息
     * @param jsonHouse (房产信息列表）
     * @return（0：待更新的房产列表为空 1：更新或添加成功 2：添加异常)
     */
    @ResponseBody
    @RequestMapping(value = "/appHouseUpadteALL",method = RequestMethod.POST)
    public String appHouseUpadteALL(String jsonHouse){
        System.out.println("更新所有房产");
        if(jsonHouse==null||jsonHouse.equals(""))
            return "0";
        List<HouseDO> houseDOList= null;
        try {
            houseDOList = JsonConvert.jsonToObjectList(jsonHouse,HouseDO.class);
            for(HouseDO houseDO:houseDOList){
                if(houseDO.getId()==null||houseDO.getId().equals(""))
                    houseService.insert(houseDO);
                else
                    houseService.update(houseDO);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "2";
        }
        return "1";
    }

    /**
     * 添加一套房产信息
     * @param houseDO
     * @return （0：待更新的房产列表为空 1：更新或添加成功 2：添加异常)
     */
    @RequestMapping(value = "/appHouseAdd",method = RequestMethod.POST)
    @ResponseBody
    public String appHouseAdd(@RequestBody HouseDO houseDO){
        System.out.println("添加一个新的房产");
        if(houseDO.getUserid()==null||houseDO.getUserid().equals(""))
            return "0";
        int userid=houseDO.getUserid();
        if(userService.IfExistsByUserId(userid)){
            houseService.insert(houseDO);
            return "1";
        }else{
            return "2";
        }
    }

//    @RequestMapping(value = "/test",method = RequestMethod.GET)
//    @ResponseBody
//    public String test(){
//        String jsonHouse="[{\"cityofhouse\":\"\",\"numofcertificate\":\"9001\",\"price\":100,\"housetype\":\"\",\"address\":\"\"},{\"payment\":13,\"cityofhouse\":\"日照\",\"numofcertificate\":\"9000\",\"address\":\"山东日照\",\"price\":13,\"housetype\":\"1\",\"area\":90}]";
//        if(jsonHouse==null||jsonHouse.equals(""))
//            return "0";
//        List<HouseDO> houseDOList= null;
//        try {
//            houseDOList = JsonConvert.jsonToObjectList(jsonHouse,HouseDO.class);
//            for(HouseDO houseDO:houseDOList){
//                if(houseDO.getId()==null||houseDO.getId().equals(""))
//                    houseService.insert(houseDO);
//                else
//                    houseService.update(houseDO);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "2";
//        }
//        return "1";
//    }
}
