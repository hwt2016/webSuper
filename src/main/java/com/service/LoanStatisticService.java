package com.service;

import com.entity.LoanStatisticDO;
import com.entity.LoanStatisticDOExample;
import com.mapper.LoanStatisticDOMapper;
import com.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-08-27.
 */
@Service
public class LoanStatisticService {

    @Autowired
    private LoanStatisticDOMapper loanStatisticDOMapper;

    /**
     * 完成笔数增加1
     * @param userid
     * @param month
     */
    public void finishAdd(int userid, Date month){
        String monthConvert= DateUtil.getMonthFirstDay(month);
        LoanStatisticDOExample loanStatisticDOExample = new LoanStatisticDOExample();
        LoanStatisticDOExample.Criteria criteria = loanStatisticDOExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andMonthEqualTo(monthConvert);
        List<LoanStatisticDO> loanStatisticDOList = loanStatisticDOMapper.selectByExample(loanStatisticDOExample);
        if(loanStatisticDOList!=null){
            LoanStatisticDO loanStatisticDO =loanStatisticDOList.get(0);
            loanStatisticDO.setFinish(loanStatisticDO.getFinish()+1);
            update(loanStatisticDO);
        }
    }

    /**
     * 提交笔数增加1
     * @param userid
     * @param month
     */
    public void commitAdd(int userid, Date month){
        String monthConvert= DateUtil.getMonthFirstDay(month);
        LoanStatisticDOExample loanStatisticDOExample = new LoanStatisticDOExample();
        LoanStatisticDOExample.Criteria criteria = loanStatisticDOExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andMonthEqualTo(monthConvert);
        List<LoanStatisticDO> loanStatisticDOList = loanStatisticDOMapper.selectByExample(loanStatisticDOExample);
        if(loanStatisticDOList.size()!=0){
            LoanStatisticDO loanStatisticDO =loanStatisticDOList.get(0);
            loanStatisticDO.setCommit(loanStatisticDO.getCommit()+1);
            update(loanStatisticDO);
        }
    }

    /**
     * 更新loanStatistic
     * @param loanStatisticDO
     */
    public void update(LoanStatisticDO loanStatisticDO){
        loanStatisticDO.setUpdatetime(new Date(System.currentTimeMillis()));
        loanStatisticDOMapper.updateByPrimaryKeySelective(loanStatisticDO);
    }


    /**
     * 插入一条贷款数据记录
     * @param loanStatisticDO
     */
    public void insert(LoanStatisticDO loanStatisticDO){
        System.out.println("来一把");
        loanStatisticDO.setCreatetime(new Date(System.currentTimeMillis()));
        loanStatisticDO.setUpdatetime(new Date(System.currentTimeMillis()));
        loanStatisticDOMapper.insert(loanStatisticDO);
    }

    /**
     * 根据userid和当前月份提取信息
     * @param userid
     * @param month
     * @return
     */
    public  LoanStatisticDO selectByUserIdAndMonthNow(int userid, Date month){
        String monthConvert= DateUtil.getMonthFirstDay(month);
        LoanStatisticDOExample loanStatisticDOExample = new LoanStatisticDOExample();
        LoanStatisticDOExample.Criteria criteria = loanStatisticDOExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andMonthEqualTo(monthConvert);
        List<LoanStatisticDO> loanStatisticDOList = loanStatisticDOMapper.selectByExample(loanStatisticDOExample);
        if(loanStatisticDOList.size()!=0)
            return loanStatisticDOList.get(0);
        else
            return null;

    }

    /**
     * 根据userid和month提取某个月的信息
     * @param userid
     * @param month
     * @return
     */
    public  LoanStatisticDO selectByUserIdAndMonthString(int userid, String month){
        LoanStatisticDOExample loanStatisticDOExample = new LoanStatisticDOExample();
        LoanStatisticDOExample.Criteria criteria = loanStatisticDOExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andMonthEqualTo(month);
        List<LoanStatisticDO> loanStatisticDOList = loanStatisticDOMapper.selectByExample(loanStatisticDOExample);
        if(loanStatisticDOList.size()!=0)
            return loanStatisticDOList.get(0);
        else
            return null;
    }

    /**
     * 根据userdi提取某人每个月的交易信息
     * @param userid
     * @return
     */
    public  List<LoanStatisticDO> selectByUserId(int userid){
        LoanStatisticDOExample loanStatisticDOExample = new LoanStatisticDOExample();
        LoanStatisticDOExample.Criteria criteria = loanStatisticDOExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<LoanStatisticDO> loanStatisticDOList = loanStatisticDOMapper.selectByExample(loanStatisticDOExample);
        return loanStatisticDOList;
    }

}
