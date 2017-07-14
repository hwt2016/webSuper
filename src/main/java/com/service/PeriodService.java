package com.service;

import com.entity.PeriodDO;
import com.entity.PeriodDOExample;
import com.mapper.PeriodDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sa on 2017-06-18.
 * 阶段信息表接口信息
 */
@Service
public class PeriodService {

    @Autowired
    private PeriodDOMapper periodDOMapper;
    //************** select  提取*************************************************
    //根据不同的阶段选取相应的列表信息
    public List<PeriodDO> selectByStatus(String status){
        PeriodDOExample periodDOExample = new PeriodDOExample();
        PeriodDOExample.Criteria criteria = periodDOExample.createCriteria();
        criteria.andStatusEqualTo(status);
        List<PeriodDO> periodDOS = periodDOMapper.selectByExample(periodDOExample);

        return periodDOS;

    }

    //根据受理ID提取阶段信息
    public PeriodDO selectByAcceptId(int acceptid){
        PeriodDOExample periodDOExample = new PeriodDOExample();
        PeriodDOExample.Criteria criteria = periodDOExample.createCriteria();
        criteria.andAcceptidEqualTo(acceptid);
        List<PeriodDO> periodDOS = periodDOMapper.selectByExample(periodDOExample);

        return periodDOS.get(0);
    }
}
