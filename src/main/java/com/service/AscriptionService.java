package com.service;

import com.entity.AscriptionDO;
import com.entity.AscriptionDOExample;
import com.mapper.AscriptionDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sa on 2017-06-06.
 * 上下级归属接口
 */
@Service
public class AscriptionService {

    @Autowired
    private AscriptionDOMapper ascriptionDOMapper;
    //************** insert  插入*************************************************
    //新增上下级归属
    public boolean insert(AscriptionDO ascriptionDO){
        ascriptionDOMapper.insert(ascriptionDO);
        return true;
    }


    //************** select  提取*************************************************

    //根据下级userid提取归属关系对象
    public AscriptionDO selectBydownGradeUserId(int downUserId){
        AscriptionDOExample ascriptionDOExample = new AscriptionDOExample();
        AscriptionDOExample.Criteria criteria = ascriptionDOExample.createCriteria();
        criteria.andDownuseridEqualTo(downUserId);
        List<AscriptionDO> ascriptionDOS = ascriptionDOMapper.selectByExample(ascriptionDOExample);
        if(ascriptionDOS.size()!=0)
            return ascriptionDOS.get(0);
        else
            return null;
    }



    //根据上级userid提取所有归属关系对象
    public List<AscriptionDO> selectByupGradeUserId(int upUserId){
        AscriptionDOExample ascriptionDOExample = new AscriptionDOExample();
        AscriptionDOExample.Criteria criteria = ascriptionDOExample.createCriteria();
        criteria.andUpuseridEqualTo(upUserId);
        List<AscriptionDO> ascriptionDOS = ascriptionDOMapper.selectByExample(ascriptionDOExample);
        if(ascriptionDOS.size()!=0)
            return ascriptionDOS;
        else
            return null;
    }


    //************** update  更新*************************************************

    //更新归属关系对象
    public boolean update(AscriptionDO ascriptionDO){
        ascriptionDOMapper.updateByPrimaryKeySelective(ascriptionDO);
        return true;
    }

    //************** delete  删除*************************************************

    //根据id删除归属关系对象
    public boolean delete(int id){
        ascriptionDOMapper.deleteByPrimaryKey(id);
        return true;
    }

    //根据上级userid删除它的所有归属关系
    public boolean deleteAscsByUpGradeUserId(int upUserId){
        AscriptionDOExample ascriptionDOExample = new AscriptionDOExample();
        AscriptionDOExample.Criteria criteria = ascriptionDOExample.createCriteria();
        criteria.andUpuseridEqualTo(upUserId);
        ascriptionDOMapper.deleteByExample(ascriptionDOExample);
        return true;

    }

    //根据下级级userid删除它的所有归属关系
    public boolean deleteAscsByDownGradeUserId(int downUserId){
        AscriptionDOExample ascriptionDOExample = new AscriptionDOExample();
        AscriptionDOExample.Criteria criteria = ascriptionDOExample.createCriteria();
        criteria.andDownuseridEqualTo(downUserId);
        ascriptionDOMapper.deleteByExample(ascriptionDOExample);
        return true;

    }
}
