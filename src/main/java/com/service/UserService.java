package com.service;

import com.em.StatusEnum;
import com.entity.UserDO;
import com.entity.UserDOExample;
import com.mapper.UserDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by hwt on 2017/5/25.
 * 与User相关的操作
 */
@Service
public class UserService {

    @Autowired
    private UserDOMapper userDOMapper;
    //======     insert  插入操作=================================================================================================
    //插入一个用户
    public boolean insert(UserDO userDO){
        userDO.setCreatetime(new Date(System.currentTimeMillis()));
        userDO.setUpdatetime(new Date(System.currentTimeMillis()));
        userDOMapper.insert(userDO);
        return true;
    }


    //======     select  提取操作=================================================================================================

    //根据用户状态生成用户列表
    public List<UserDO> selectUsersByState(String state){
        UserDOExample userDOExample = new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andStatusEqualTo(state);
        List<UserDO> userDOList = userDOMapper.selectByExample(userDOExample);

        return userDOList;

    }

    //选取某个等级的所有用户
    public List<UserDO> selectPositonOfWhich(String grade){
        UserDOExample userDOExample= new UserDOExample();
        userDOExample.setOrderByClause("id ASC");
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andStatusNotEqualTo(StatusEnum.DELETED.code());
        criteria.andGradeEqualTo(grade);
        List<UserDO> userDOList=userDOMapper.selectByExample(userDOExample);

        return userDOList;
    }

    //根据手机号判断用户是否存在
    public boolean IfExists(UserDO userDO){
        UserDOExample userDOExample= new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andPhoneEqualTo(userDO.getPhone());
        criteria.andStatusNotEqualTo(StatusEnum.DELETED.code());
        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);
        if(userDOS.size()!=0)
            return true;
        else
            return false;
    }


    //根据手机号提取用户信息
    public UserDO selectUserByPhone(UserDO userDO){
        UserDOExample userDOExample= new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andPhoneEqualTo(userDO.getPhone());
        criteria.andStatusNotEqualTo(StatusEnum.DELETED.code());
        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);
        if(userDOS.size()!=0)
            return userDOS.get(0);
        else
            return null;
    }

    //根据手机号提取用户信息
    public UserDO selectUserByPhoneNum(String phone){
        UserDOExample userDOExample= new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        criteria.andStatusNotEqualTo(StatusEnum.DELETED.code());
        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);
        if(userDOS.size()!=0)
            return userDOS.get(0);
        else
            return null;
    }

    //根据id选取用户
    public UserDO selectUserById(int userid){
        UserDO userDO = userDOMapper.selectByPrimaryKey(userid);
        return  userDO;
    }


    //======     delete  删除操作=================================================================================================
    public boolean delete(UserDO userDO){
        UserDO userDO1 = selectUserByPhone(userDO);
        if(userDO1!=null)
            userDOMapper.deleteByPrimaryKey(userDO1.getId());
        else
            return false;
        return true;
    }
    //======     update  更新操作=================================================================================================

    //根据主键更新用户基本信息
    public boolean update(UserDO userDO){
        userDO.setUpdatetime(new Date(System.currentTimeMillis()));
        userDOMapper.updateByPrimaryKeySelective(userDO);//更新userDO中属性不为null的字段
        return true;
    }

}
