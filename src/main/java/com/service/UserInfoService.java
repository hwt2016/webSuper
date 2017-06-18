package com.service;

import com.entity.UserInfoDO;
import com.entity.UserInfoDOExample;
import com.mapper.UserInfoDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sa on 2017-06-06.
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoDOMapper userInfoDOMapper;
    //************** insert  插入*************************************************
    //插入一条用户信息
    public boolean insert(UserInfoDO userInfoDO){
        userInfoDOMapper.insert(userInfoDO);
        return true;
    }

    //************** select  提取*************************************************
    //根据用户userid提取用户详细信息
    public UserInfoDO selectUserInfoByUserId(int userid){
        UserInfoDOExample userInfoDOExample = new UserInfoDOExample();
        UserInfoDOExample.Criteria criteria = userInfoDOExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<UserInfoDO> userInfoDOS = userInfoDOMapper.selectByExample(userInfoDOExample);
        if(userInfoDOS.size()!=0)
            return userInfoDOS.get(0);
        else
            return null;
    }

    //根据userInfoId提取用户详细信息
    public UserInfoDO selectUserInfoById(int userInfoId){
        UserInfoDO userInfoDO = userInfoDOMapper.selectByPrimaryKey(userInfoId);
        return userInfoDO;
    }

    public boolean update(UserInfoDO userInfoDO){
        userInfoDOMapper.updateByPrimaryKeySelective(userInfoDO);
        return true;
    }
}
