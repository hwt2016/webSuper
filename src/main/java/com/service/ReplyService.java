package com.service;

import com.em.PeriodStatusEnum;
import com.entity.*;
import com.mapper.ReplyDOMapper;
import com.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-06-19.
 * 批复接口
 */
@Service
public class ReplyService {

    @Autowired
    private ReplyDOMapper replyDOMapper;

    @Autowired
    private MonitorService monitorService;

    @Autowired
    private LoanStatisticService loanStatisticService;

    @Autowired
    private LoanService loanService;

    @Autowired
    private AscriptionService ascriptionService;

    @Autowired
    private LoanTrackingService loanTrackingService;

    //************** insert  插入*************************************************

    //插入一条新的批复记录
    public boolean insert(ReplyDO replyDO){
        replyDO.setCreatetime(new Date(System.currentTimeMillis()));
        replyDO.setUpdatetime(new Date(System.currentTimeMillis()));
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

    /**
     * 根据主键id更新相关字段
     * @param replyDO
     * @return
     */
    public boolean update(ReplyDO replyDO) {
        replyDO.setUpdatetime(new Date(System.currentTimeMillis()));
        replyDOMapper.updateByPrimaryKeySelective(replyDO);
        return true;
    }

    /**
     * 根据loanid更新
     *更新replyDO不为null的字段
     * @param replyDO
     */
    public void updateByLoanID(ReplyDO replyDO){
        ReplyDOExample replyDOExample = new ReplyDOExample();
        ReplyDOExample.Criteria criteria = replyDOExample.createCriteria();
        criteria.andLoanidEqualTo(replyDO.getLoanid());
        replyDOMapper.updateByExampleSelective(replyDO,replyDOExample);
    }

    @Transactional
    public String replyCope(int replyid){
        try{
            //初始化一个对象
            ReplyDO replyDO = new ReplyDO();
            //设置更新的replyid
            replyDO.setId(replyid);
            //设置更新的状态：通过
            replyDO.setStatus(PeriodStatusEnum.pass.code());

            if(this.update(replyDO)){
                replyDO =this.selectReplyByID(replyid);
                //提取该贷款的信息
                LoanDO loanDO = loanService.selectLoanDOById(replyDO.getLoanid());
                //获取当前时间
                Date date = new Date(System.currentTimeMillis());
                //选取负责该用户的上级信息
                AscriptionDO ascriptionDO = ascriptionService.selectBydownGradeUserId(loanDO.getUserid());
                //更新贷款统计记录
                LoanStatisticDO loanStatisticDO = loanStatisticService.selectByUserIdAndMonthNow(ascriptionDO.getUpuserid(),date);
                //该贷款的完成笔数加1
                if (loanStatisticDO==null)
                    return "false";
                else {
                    loanStatisticService.finishAdd(ascriptionDO.getUpuserid(),date);
                    //更新该笔贷款追踪信息中的完成时间
                    LoanTrackingDO loanTrackingDO = new LoanTrackingDO();
                    loanTrackingDO.setLoanid(loanDO.getId());
                    loanTrackingDO.setMonthfinish(DateUtil.getMonthFirstDay(date));
                    loanTrackingService.update(loanTrackingDO);
                }
                //初始化一个贷后监控对象
                MonitorDO monitorDO = new MonitorDO();
                //设置审贷ID:loanid
                monitorDO.setLoanid(replyDO.getLoanid());
                //设置批复状态：批复中
                monitorDO.setStatus(PeriodStatusEnum.monitor.code());
                //更新一条批复记录
                monitorService.updateByLoanID(monitorDO);
                return "true";
            }

            else
                return "false";
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }

}
