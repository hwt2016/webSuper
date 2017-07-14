package com.entityConvert;

import com.convert.DateConvert;
import com.entity.MonitorDO;

/**
 * Created by sa on 2017-06-19.
 */
public class MonitorDOConvertMethod {

    //将MonitorDO转换成MonitorDOConvert
    public static MonitorDOConvert MonitorDOToMonitorDOConvert(MonitorDO monitorDO){
        MonitorDOConvert monitorDOConvert = new MonitorDOConvert();
        monitorDOConvert.setId(monitorDO.getId());
        monitorDOConvert.setLoanid(monitorDO.getLoanid());
        monitorDOConvert.setEndofbusiness(DateConvert.dateToStr(monitorDO.getEndofbusiness()));
        monitorDOConvert.setPayamount(monitorDO.getPayamount());
        monitorDOConvert.setPaydate(DateConvert.dateToStr(monitorDO.getPaydate()));
        monitorDOConvert.setPaymethod(monitorDO.getPaymethod());
        monitorDOConvert.setStatus(monitorDO.getStatus());
        monitorDOConvert.setCreatetime(DateConvert.dateToStrLong(monitorDO.getCreatetime()));
        monitorDOConvert.setUpdatetime(DateConvert.dateToStrLong(monitorDO.getUpdatetime()));
        return monitorDOConvert;
    }

    //将MonitorDO转换成MonitorDOConvert
    public static MonitorDO MonitorDOConvertToMonitorDO(MonitorDOConvert monitorDOConvert){
        MonitorDO monitorDO = new MonitorDO();
        monitorDO.setId(monitorDOConvert.getId());
        monitorDO.setLoanid(monitorDOConvert.getLoanid());
        monitorDO.setPaymethod(monitorDOConvert.getPaymethod());
        monitorDO.setPayamount(monitorDOConvert.getPayamount());
        monitorDO.setEndofbusiness(DateConvert.strToDate(monitorDOConvert.getEndofbusiness()));
        monitorDO.setPaydate(DateConvert.strToDate(monitorDOConvert.getPaydate()));
        monitorDO.setStatus(monitorDO.getStatus());
        return monitorDO;
    }
}
