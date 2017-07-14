package com.entityConvert;

import com.convert.DateConvert;
import com.entity.ReplyDO;

/**
 * Created by sa on 2017-06-19.
 */
public class ReplyDOConvertMethod {

    //将replyDO转换成ReplyDOConvert
    public static ReplyDOConvert replyDOToReplyDOConvert(ReplyDO replyDO){
        ReplyDOConvert replyDOConvert = new ReplyDOConvert();
        replyDOConvert.setId(replyDO.getId());
        replyDOConvert.setLoanid(replyDO.getLoanid());
        replyDOConvert.setReplyamount(replyDO.getReplyamount());

        replyDOConvert.setReplydeadline(DateConvert.dateToStr(replyDO.getReplydeadline()));
        replyDOConvert.setReplyinstitution(replyDO.getReplyinstitution());
        replyDOConvert.setReplyrate(replyDO.getReplyrate());
        replyDOConvert.setCreatetime(DateConvert.dateToStrLong(replyDO.getCreatetime()));
        replyDOConvert.setUpdatetime(DateConvert.dateToStrLong(replyDO.getUpdatetime()));
        replyDOConvert.setStatus(replyDO.getStatus());
        return replyDOConvert;
    }

    //将ReplyDOConvert转换成replyDO
    public static ReplyDO replyDOConvertToReplyDO(ReplyDOConvert replyDOConvert){
        ReplyDO replyDO = new ReplyDO();
        replyDO.setId(replyDOConvert.getId());
        replyDO.setLoanid(replyDOConvert.getLoanid());
        replyDO.setReplyamount(replyDOConvert.getReplyamount());
        replyDO.setReplydeadline(DateConvert.strToDate(replyDOConvert.getReplydeadline()));
        replyDO.setReplyinstitution(replyDOConvert.getReplyinstitution());
        replyDO.setReplyrate(replyDOConvert.getReplyrate());
        replyDO.setStatus(replyDOConvert.getStatus());
        return replyDO;
    }

}
