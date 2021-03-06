package com.service;

import com.entity.AcceptDO;
import com.entity.AcceptDOExample;
import com.mapper.AcceptDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-06-18.
 * 受理信息表相关接口
 */
@Service
public class AcceptService {

    @Autowired
    private AcceptDOMapper acceptDOMapper;


    //======提取操作=================================================================================================

    //根据受理状态提取所有的受理列表
    public List<AcceptDO> selectAcceptListByStatus(String status){
        AcceptDOExample acceptDOExample = new AcceptDOExample();
        AcceptDOExample.Criteria criteria = acceptDOExample.createCriteria();
        criteria.andStatusEqualTo(status);
        List<AcceptDO> acceptDOS = acceptDOMapper.selectByExample(acceptDOExample);

        return  acceptDOS;
    }

    //根据Accept的ID提取受理信息
    public AcceptDO selectAcceptDOById(int id){
        AcceptDO acceptDO = acceptDOMapper.selectByPrimaryKey(id);

        return acceptDO;
    }


    //======更新操作=================================================================================================


    //更新受理信息
    public boolean update(AcceptDO acceptDO){
        acceptDO.setUpdatetime(new Date(System.currentTimeMillis()));
        acceptDOMapper.updateByPrimaryKeySelective(acceptDO);
        return true;
    }

    /**
     * 插入一条新的受理信息
     * @param acceptDO
     * @return  返回新增的受理id
     */
    public int insert(AcceptDO acceptDO){
        acceptDO.setCreatetime(new Date(System.currentTimeMillis()));
        acceptDO.setUpdatetime(new Date(System.currentTimeMillis()));
        if(acceptDOMapper.insert(acceptDO)==1)
            return acceptDO.getId();
        return 0;
    }
}
