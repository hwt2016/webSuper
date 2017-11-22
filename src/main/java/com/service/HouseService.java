package com.service;

import com.entity.HouseDO;
import com.entity.HouseDOExample;
import com.mapper.HouseDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-06-06.
 */
@Service
public class HouseService {

    @Autowired
    private HouseDOMapper houseDOMapper;
    //************** insert  插入*************************************************
    //新增用户房产信息
    public boolean insert(HouseDO houseDO){
        houseDO.setCreatetime(new Date(System.currentTimeMillis()));
        houseDO.setUpdatetime(new Date(System.currentTimeMillis()));
        houseDOMapper.insert(houseDO);
        return true;
    }


    //************** select  提取*************************************************

    //根据用户userid提取该用户的房屋信息列表
    public List<HouseDO> selectHousesByUserid(int userid){
        HouseDOExample houseDOExample = new HouseDOExample();
        HouseDOExample.Criteria criteria = houseDOExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andStatusEqualTo("正常");
        List<HouseDO> houseDOS = houseDOMapper.selectByExample(houseDOExample);
        return houseDOS;
    }

    //根据id提取房屋信息
    public HouseDO selectHouseById(int houseid){
        HouseDO houseDO= houseDOMapper.selectByPrimaryKey(houseid);
        return houseDO;
    }

    //************** update  更新*************************************************

    //根据houseid更新房产信息
    public boolean update(HouseDO houseDO){
        houseDO.setUpdatetime(new Date(System.currentTimeMillis()));
        houseDOMapper.updateByPrimaryKeySelective(houseDO);
        return true;
    }


    //************** delete  删除*************************************************

    //根据houseid删除一个房产
    public boolean delete(int houseid){
        try{
            houseDOMapper.deleteByPrimaryKey(houseid);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

}
