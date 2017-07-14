package com.entityConvert;

import com.convert.DateConvert;
import com.entity.ApprovalDO;

/**
 * Created by sa on 2017-06-19.
 */
public class ApprovalDOConvertMethod {

    //将ApprovalDO转换成ApprovalDOConvert
    public static ApprovalDOConvert approvalDOToApprovalDOConvert(ApprovalDO approvalDO){
        ApprovalDOConvert approvalDOConvert = new ApprovalDOConvert();
        approvalDOConvert.setId(approvalDO.getId());
        approvalDOConvert.setLoanid(approvalDO.getLoanid());
        approvalDOConvert.setRongamount(approvalDO.getRongamount());
        approvalDOConvert.setRongrate(approvalDO.getRongrate());
        approvalDOConvert.setRongdeadline(DateConvert.dateToStr(approvalDO.getRongdeadline()));
        approvalDOConvert.setRongtarget(approvalDO.getRongtarget());
        approvalDOConvert.setCreatetime(DateConvert.dateToStr(approvalDO.getCreatetime()));
        approvalDOConvert.setUpdatetime(DateConvert.dateToStr(approvalDO.getUpdatetime()));
        approvalDOConvert.setStatus(approvalDO.getStatus());
        return approvalDOConvert;
    }

    //将ApprovalDOConvert转换成ApprovalDO
    public static ApprovalDO approvalDOConvertToApprovalDO(ApprovalDOConvert approvalDOConvert){
        ApprovalDO approvalDO = new ApprovalDO();
        approvalDO.setId(approvalDOConvert.getId());
        approvalDO.setLoanid(approvalDOConvert.getLoanid());
        approvalDO.setRongamount(approvalDOConvert.getRongamount());
        approvalDO.setRongrate(approvalDOConvert.getRongrate());
        approvalDO.setRongdeadline(DateConvert.strToDate(approvalDOConvert.getRongdeadline()));
        approvalDO.setRongtarget(approvalDOConvert.getRongtarget());
        approvalDO.setStatus(approvalDOConvert.getStatus());
        return approvalDO;
    }
}
