package com.service;

import com.entity.VehicleDO;
import com.entity.VehicleDOExample;
import com.mapper.VehicleDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sa on 2017-06-06.
 */
@Service
public class VehicleService {

    @Autowired
    private VehicleDOMapper vehicleDOMapper;

    //************** select  提取*************************************************

    //根据用户userid提取该用户的车辆信息列表
    public List<VehicleDO> selectVehiclesByUserid(int userid){
        VehicleDOExample vehicleDOExample = new VehicleDOExample();
        VehicleDOExample.Criteria criteria = vehicleDOExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<VehicleDO> vehicleDOS = vehicleDOMapper.selectByExample(vehicleDOExample);
        return vehicleDOS;
    }

    //根据车辆id获取车辆信息
    public VehicleDO selectVehicleById(int vehicleid){
        VehicleDO vehicleDO = vehicleDOMapper.selectByPrimaryKey(vehicleid);
        return  vehicleDO;
    }



    //************** insert  插入*************************************************

    //插入一条车辆信息
    public boolean insert(VehicleDO vehicleDO){
        vehicleDOMapper.insert(vehicleDO);
        return true;
    }

    //************** update  更新*************************************************

    //根据车辆id更新车辆信息
    public boolean update(VehicleDO vehicleDO){
        vehicleDOMapper.updateByPrimaryKeySelective(vehicleDO);
        return true;
    }
}
