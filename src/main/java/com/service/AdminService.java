package com.service;

import com.entity.AdminDO;
import com.mapper.AdminDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sa on 2017-05-31.
 * 提供关于admin相关的接口
 */
@Service
public class AdminService {

    @Autowired
    private AdminDOMapper adminDOMapper;

    public boolean codeModify(AdminDO adminDO){
        adminDOMapper.updateByPrimaryKeySelective(adminDO);
        return true;
    }

}
