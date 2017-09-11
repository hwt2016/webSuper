package com.service;

import com.entity.UserIncomeDO;
import com.mapper.UserIncomeDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by sa on 2017-09-10.
 */
@Service
public class UserIncomeService {

    @Autowired
    private UserIncomeDOMapper userIncomeDOMapper;

    /**
     * 插入一条记录
     * @param userIncomeDO
     */
    public void insert(UserIncomeDO userIncomeDO){
        userIncomeDO.setUpdatetime(new Date(System.currentTimeMillis()));
        userIncomeDO.setCreattime(new Date(System.currentTimeMillis()));
        userIncomeDOMapper.insert(userIncomeDO);

    }
}
