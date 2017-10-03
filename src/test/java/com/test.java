package com;

import com.entity.UserDO;
import com.service.AdminService;
import com.service.UserInfoService;
import com.service.UserService;
import com.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sa on 2017-08-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class test {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserService userService;
    

    @Test
    public void test()  {
        UserDO userDO = new UserDO();
        userDO.setPhone("17853273057");
        userDO.setPassword(MD5Util.GetMD5Code("12345"));
        userService.updateByPhone(userDO);


    }


//    public  static void main(String args[]){
//
//        int a=3;
//        if(a==null){
//
//        }
//    }
}
