package com.service;

import com.entity.MonitorDO;
import com.entity.MonitorDOExample;
import com.mapper.MonitorDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-06-19.
 */
@Service
public class MonitorService {

    @Autowired
    private MonitorDOMapper monitorDOMapper;

    //************** select  提取*************************************************

    //根据状态提取贷后监控列表
    public List<MonitorDO> selectMonitorDOSByStatus(String status){
        MonitorDOExample monitorDOExample = new MonitorDOExample();
        MonitorDOExample.Criteria criteria = monitorDOExample.createCriteria();
        criteria.andStatusEqualTo(status);
        List<MonitorDO> monitorDOS = monitorDOMapper.selectByExample(monitorDOExample);
        return monitorDOS;

    }

    //根据monitorid提取贷后监控信息
    public MonitorDO selectMonitorById(int monitorid){
        MonitorDO monitorDO = monitorDOMapper.selectByPrimaryKey(monitorid);
        return monitorDO;
    }
    //************** insert  新增*************************************************

    //插入一条贷后监控记录
    public boolean insert(MonitorDO monitorDO){
        monitorDO.setUpdatetime(new Date(System.currentTimeMillis()));
        monitorDO.setCreatetime(new Date(System.currentTimeMillis()));
        monitorDOMapper.insert(monitorDO);
        return true;
    }

    //更新参数中变量不为null的数据
    public boolean update(MonitorDO monitorDO) {
        monitorDO.setUpdatetime(new Date(System.currentTimeMillis()));
        monitorDOMapper.updateByPrimaryKeySelective(monitorDO);
        return true;
    }
}
