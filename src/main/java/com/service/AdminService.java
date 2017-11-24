package com.service;

import com.em.StatusEnum;
import com.entity.AdminDO;
import com.entity.AdminDOExample;
import com.mapper.AdminDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //密码修改
    public boolean codeModify(AdminDO adminDO){
        try{
            adminDOMapper.updateByPrimaryKeySelective(adminDO);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    //添加一位管理员
    public boolean insert(AdminDO adminDO){
        try{
            adminDOMapper.insert(adminDO);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }

    //判断管理员是否存在
    public boolean ifExists(AdminDO adminDO){
          try {
              AdminDOExample adminDOExample = new AdminDOExample();
              AdminDOExample.Criteria criteria =adminDOExample.createCriteria();
              criteria.andAdminnameEqualTo(adminDO.getAdminname());
              criteria.andStatusEqualTo(StatusEnum.NORMAL.code());
              List<AdminDO> adminDOList = adminDOMapper.selectByExample(adminDOExample);
              if(adminDOList.size()!=0)
                  return true;
              else
                  return false;
          }catch (Exception e){
              e.printStackTrace();
              return false;
          }
    }

    //根据用户名提取管理员账号
    public AdminDO selectAdminByAdminName(String adminname){
        try {
            AdminDOExample adminDOExample = new AdminDOExample();
            AdminDOExample.Criteria criteria =adminDOExample.createCriteria();
            criteria.andAdminnameEqualTo(adminname);
            criteria.andStatusEqualTo(StatusEnum.NORMAL.code());
            List<AdminDO> adminDOList = adminDOMapper.selectByExample(adminDOExample);
            if(adminDOList.size()!=0)
                return adminDOList.get(0);
            else
                return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }




}
