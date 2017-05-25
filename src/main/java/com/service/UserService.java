package com.service;

import com.entity.UserDO;
import com.mapper.UserDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hwt on 2017/5/25.
 */
@Service
public class UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    public void insert(UserDO userDO){
        userDOMapper.insert(userDO);
    }

}
