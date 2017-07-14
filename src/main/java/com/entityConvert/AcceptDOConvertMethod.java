package com.entityConvert;

import com.convert.DateConvert;
import com.entity.AcceptDO;

/**
 * Created by sa on 2017-06-19.
 */
public class AcceptDOConvertMethod {


    //将AcceptDO转换成AcceptDOConvert
    public static AcceptDOConvert acceptDOToAcceptDOConvert(AcceptDO acceptDO){
        AcceptDOConvert acceptDOConvert = new AcceptDOConvert();
        acceptDOConvert.setId(acceptDO.getId());
        acceptDOConvert.setLoanid(acceptDO.getLoanid());
        acceptDOConvert.setStatus(acceptDO.getStatus());
        acceptDOConvert.setDealview(acceptDO.getDealview());
        acceptDOConvert.setDealmanagerid(acceptDO.getDealmanagerid());
        acceptDOConvert.setDealmanagername(acceptDO.getDealmanagername());
        acceptDOConvert.setCreatetime(DateConvert.dateToStr(acceptDO.getCreatetime()));
        acceptDOConvert.setUpdatetime(DateConvert.dateToStr(acceptDO.getUpdatetime()));
        return acceptDOConvert;
    }
    //将AcceptDOConvert转换成AcceptDO
    public static AcceptDO acceptDOConvertToAcceptDO(AcceptDOConvert acceptDOConvert){
        AcceptDO acceptDO = new AcceptDO();
        acceptDO.setId(acceptDOConvert.getId());
        acceptDO.setId(acceptDOConvert.getId());
        acceptDO.setStatus(acceptDOConvert.getStatus());
        acceptDO.setDealview(acceptDOConvert.getDealview());
        acceptDO.setDealmanagerid(acceptDOConvert.getDealmanagerid());
        return acceptDO;
    }
}
