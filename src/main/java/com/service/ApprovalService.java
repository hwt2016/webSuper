package com.service;

import com.entity.ApprovalDO;
import com.entity.ApprovalDOExample;
import com.mapper.ApprovalDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-06-19.
 * 审批接口
 */
@Service
public class ApprovalService {

    @Autowired
    private ApprovalDOMapper approvalDOMapper;

    //======插入操作=================================================================================================
    //插入一个审批对象
    public boolean insert(ApprovalDO approvalDO){
        approvalDO.setCreatetime(new Date(System.currentTimeMillis()));
        approvalDO.setUpdatetime(new Date(System.currentTimeMillis()));
        approvalDOMapper.insert(approvalDO);
        return true;
    }


    //======提取操作=================================================================================================

    //根据审批状态提取所有的受理列表
    public List<ApprovalDO> selectApprovalByStatus(String status){
        ApprovalDOExample approvalDOExample = new ApprovalDOExample();
        ApprovalDOExample.Criteria criteria = approvalDOExample.createCriteria();
        criteria.andStatusEqualTo(status);
        List<ApprovalDO> approvalDOS = approvalDOMapper.selectByExample(approvalDOExample);

        return approvalDOS;
    }

    //根据ID提取审批信息
    public ApprovalDO selectById(int approvalid){
        ApprovalDO approvalDO = approvalDOMapper.selectByPrimaryKey(approvalid);
        return approvalDO;
    }

    //更新批复信息（只更新参数中不为null的部分）
    public boolean update(ApprovalDO approvalDO) {
        approvalDO.setUpdatetime(new Date(System.currentTimeMillis()));
        approvalDOMapper.updateByPrimaryKeySelective(approvalDO);
        return true;
    }
}
