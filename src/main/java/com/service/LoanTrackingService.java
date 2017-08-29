package com.service;

import com.entity.LoanTrackingDO;
import com.entity.LoanTrackingDOExample;
import com.mapper.LoanTrackingDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-08-26.
 */
@Service
public class LoanTrackingService {

    @Autowired
    private LoanTrackingDOMapper loanTrackingDOMapper;


    public LoanTrackingDO selectLoanTrackingDOById(int loantrackingid){
        LoanTrackingDO loanTrackingDO = loanTrackingDOMapper.selectByPrimaryKey(loantrackingid);
        return loanTrackingDO;
    }

    /**
     * 根据loanid提取贷款追踪信息
     * @param loanid
     * @return
     */
    public LoanTrackingDO selectLoanTackingDOByLoanId(int loanid){
        LoanTrackingDOExample loanTrackingDOExample= new LoanTrackingDOExample();
        LoanTrackingDOExample.Criteria criteria = loanTrackingDOExample.createCriteria();
        criteria.andLoanidEqualTo(loanid);
        List<LoanTrackingDO> userDOS = loanTrackingDOMapper.selectByExample(loanTrackingDOExample);
        if(userDOS.size()!=0)
            return userDOS.get(0);
        else
            return null;
    }

    /**
     * 插入一条记录
     * @param loanTrackingDO
     * @return
     */
    public boolean insert(LoanTrackingDO loanTrackingDO){
        loanTrackingDO.setCreatetime(new Date(System.currentTimeMillis()));
        loanTrackingDO.setUpdatetime(new Date(System.currentTimeMillis()));
        loanTrackingDOMapper.insert(loanTrackingDO);
        return true;
    }

    /**
     * 根据loanTrackingID更新内容
     * @param loanTrackingDO
     * @return
     */
    public boolean update(LoanTrackingDO loanTrackingDO){
        loanTrackingDO.setUpdatetime(new Date(System.currentTimeMillis()));
        loanTrackingDOMapper.updateByPrimaryKeySelective(loanTrackingDO);
        return true;
    }


    /**
     * 根据上级userid和提交月份（monthcommit)提取该用户的所有贷款信息
     * @param upuserid:用户id  monthcommit:提交月份
     * @return
     */
    public List<LoanTrackingDO> selectLoanTrackingDOSByUpUserIdAndMonthCommit(int upuserid,String monthcommit){
        LoanTrackingDOExample loanTrackingDOExample= new LoanTrackingDOExample();
        LoanTrackingDOExample.Criteria criteria = loanTrackingDOExample.createCriteria();
        criteria.andMonthcommitEqualTo(monthcommit);
        criteria.andUpuseridEqualTo(upuserid);
        List<LoanTrackingDO> loanTrackingDOS = loanTrackingDOMapper.selectByExample(loanTrackingDOExample);
        return loanTrackingDOS;
    }

    /**
     * 根据上级userid和完成月份（monthfinish)提取该用户的所有贷款信息
     * @param upuserid:用户id  monthfinish:完成月份
     * @return
     */
    public List<LoanTrackingDO> selectLoanTrackingDOSByUpUserIdAndMonthFinish(int upuserid,String monthfinish){
        LoanTrackingDOExample loanTrackingDOExample= new LoanTrackingDOExample();
        LoanTrackingDOExample.Criteria criteria = loanTrackingDOExample.createCriteria();
        criteria.andMonthfinishEqualTo(monthfinish);
        criteria.andUpuseridEqualTo(upuserid);
        List<LoanTrackingDO> loanTrackingDOS = loanTrackingDOMapper.selectByExample(loanTrackingDOExample);
        return loanTrackingDOS;
    }

    /**
     * 根据上级upuserid得出最早的一笔贷款信息日期
     * @param upuserid
     * @return
     */
    public Date apploanTrackingEarlyDateByUserID(int upuserid){
        LoanTrackingDOExample loanTrackingDOExample= new LoanTrackingDOExample();
        LoanTrackingDOExample.Criteria criteria = loanTrackingDOExample.createCriteria();
        loanTrackingDOExample.setOrderByClause("createtime ASC");
        criteria.andUpuseridEqualTo(upuserid);
        List<LoanTrackingDO> userDOS = loanTrackingDOMapper.selectByExample(loanTrackingDOExample);
        if(userDOS!=null)
            return userDOS.get(0).getCreatetime();
//        System.out.println(userDOS.size());
        return null;
    }
}
