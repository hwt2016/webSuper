package com.service;

import com.entity.AdminDO;
import com.entity.UserInfoDO;
import com.mapper.AdminDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by sa on 2017-05-31.
 * 提供关于admin相关的接口
 */
@Service
public class AdminService {

    @Autowired
    private AdminDOMapper adminDOMapper;

    @Autowired
    private UserInfoService userInfoService;

    public boolean codeModify(AdminDO adminDO){
        adminDOMapper.updateByPrimaryKeySelective(adminDO);
        return true;
    }

    public void insert(AdminDO adminDO){


        adminDOMapper.insert(adminDO);

    }

    public String init(){
        try {

            UserInfoDO userInfoDO = new UserInfoDO();
            userInfoDO.setUserid(2);
            userInfoDO.setCreatetime(new Date(System.currentTimeMillis()));
            userInfoDO.setUpdatetime(new Date(System.currentTimeMillis()));
            userInfoDO.setStatus("正常");
            userInfoService.insert(userInfoDO);


            AdminDO adminDO = new AdminDO();
            adminDO.setAdminname("11");
            adminDO.setPassword("123");
            adminDO.setCreatetime(new Date(System.currentTimeMillis()));
            adminDO.setUpdatetime(new Date(System.currentTimeMillis()));
            adminDO.setStatus("正常");
            this.insert(adminDO);

            return "1";


//            adminDO.setAdminname("11111111");
//            adminDO.setPassword("123");
//            adminDO.setCreatetime(new Date(System.currentTimeMillis()));
//            adminDO.setUpdatetime(new Date(System.currentTimeMillis()));
//            adminDO.setStatus("正常");
//            adminService.insert(adminDO);
        }catch (Exception e){
            e.printStackTrace();
            return "2";
        }
    }

}
