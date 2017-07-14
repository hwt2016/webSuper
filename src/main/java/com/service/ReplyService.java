package com.service;

import com.entity.ReplyDO;
import com.entity.ReplyDOExample;
import com.mapper.ReplyDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sa on 2017-06-19.
 * 批复接口
 */
@Service
public class ReplyService {

    @Autowired
    private ReplyDOMapper replyDOMapper;

    //************** insert  插入*************************************************

    //插入一条新的批复记录
    public boolean insert(ReplyDO replyDO){
        replyDOMapper.insert(replyDO);
        return true;
    }

    //************** select  提取*************************************************

    //根据状态提取批复信息
    public List<ReplyDO> selectReplyDOSByStatus(String status){
        ReplyDOExample replyDOExample = new ReplyDOExample();
        ReplyDOExample.Criteria criteria = replyDOExample.createCriteria();
        criteria.andStatusEqualTo(status);
        List<ReplyDO> replyDOS = replyDOMapper.selectByExample(replyDOExample);
        return  replyDOS;

    }

    //根据replyid提取批复信息
    public ReplyDO selectReplyByID(int replyid){
        ReplyDO replyDO = replyDOMapper.selectByPrimaryKey(replyid);
        return replyDO;
    }

    public boolean update(ReplyDO replyDO) {
        replyDOMapper.updateByPrimaryKeySelective(replyDO);
        return true;
    }
}
