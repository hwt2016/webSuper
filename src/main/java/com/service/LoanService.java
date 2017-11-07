package com.service;

import com.em.PeriodStatusEnum;
import com.entity.*;
import com.mapper.LoanDOMapper;
import com.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by sa on 2017-06-18.
 * 贷款接口表
 */
@Service
public class LoanService {

    @Autowired
    private LoanDOMapper loanDOMapper;


    @Autowired
    private UserService userService;

    //受理
    @Autowired
    private AcceptService acceptService;

    //审批阶段
    @Autowired
    private ApprovalService approvalService;
    //批复
    @Autowired
    private ReplyService replyService;
    //贷后监控阶段
    @Autowired
    private MonitorService monitorService;

    @Autowired
    private LoanTrackingService loanTrackingService;

    @Autowired
    private AscriptionService ascriptionService;

    @Autowired
    private LoanStatisticService loanStatisticService;

    //************** select  提取*************************************************
    //根据贷款ID提取贷款信息
    public LoanDO selectLoanDOById(int loanid){
        LoanDO loanDO = loanDOMapper.selectByPrimaryKey(loanid);
        return loanDO;
    }



    //************** insert  新增*************************************************
    /**
     * 插入一条贷款信息
     * @param loanDO
     * @return
     */
    public int insertLoanDO(LoanDO loanDO){
        loanDO.setCreatetime(new Date(System.currentTimeMillis()));
        loanDO.setUpdatetime(new Date(System.currentTimeMillis()));
        if(loanDOMapper.insert(loanDO)==1)
            return loanDO.getId();
        return 0;
    }

    /**
     *
     * @param loanDO
     * @return （0：新增贷款信息为空 1：更新或添加成功 2：添加异常)
     */
    @Transactional
    public String appLoanInit(LoanDO loanDO){
        try {
            //如果插入成功，返回当前改变的行数，插入一条记录，所以影响的行数为1
            int loanNewID= this.insertLoanDO(loanDO);//插入成功loanNewID=1
            if(loanNewID>0){
                //选取负责该用户的上级信息
                AscriptionDO ascriptionDO = ascriptionService.selectBydownGradeUserId(loanDO.getUserid());

                //受理阶段设置状态为受理中
                AcceptDO acceptDO = new AcceptDO();
                acceptDO.setStatus(PeriodStatusEnum.accept.code());
                acceptDO.setLoanid(loanDO.getId());
                acceptService.insert(acceptDO);
                //审批阶段 设置状态为等待
                ApprovalDO approvalDO = new ApprovalDO();
                approvalDO.setStatus(PeriodStatusEnum.wait.code());
                approvalDO.setLoanid(loanDO.getId());
                approvalService.insert(approvalDO);
                //批复阶段设置状态为等待
                ReplyDO replyDO = new ReplyDO();
                replyDO.setStatus(PeriodStatusEnum.wait.code());
                replyDO.setLoanid(loanDO.getId());
                replyService.insert(replyDO);
                //贷后监控阶段 设置状态为等待
                MonitorDO monitorDO = new MonitorDO();
                monitorDO.setStatus(PeriodStatusEnum.wait.code());
                monitorDO.setLoanid(loanDO.getId());
                monitorService.insert(monitorDO);


                //获取当前时间
                Date date = new Date(System.currentTimeMillis());
                UserDO userDO = userService.selectUserById(loanDO.getUserid());

                //添加贷款追踪信息
                LoanTrackingDO loanTrackingDO = new LoanTrackingDO();
                loanTrackingDO.setUserid(loanDO.getUserid());
                loanTrackingDO.setLoanid(loanDO.getId());
                loanTrackingDO.setLoanamount(0);
                loanTrackingDO.setProfit(0.0);
                loanTrackingDO.setRealname(userDO.getRealname());
                loanTrackingDO.setMonthcommit(DateUtil.getMonthFirstDay(date));
                loanTrackingDO.setUpuserid(ascriptionDO.getUpuserid());
                loanTrackingDO.setStatus(PeriodStatusEnum.accept.code());
                loanTrackingService.insert(loanTrackingDO);


                //更新贷款统计记录
                LoanStatisticDO loanStatisticDO = loanStatisticService.selectByUserIdAndMonthNow(ascriptionDO.getUpuserid(),date);
                if(loanStatisticDO==null){
                    LoanStatisticDO loanStatisticDONew = new LoanStatisticDO();
                    loanStatisticDONew.setCommit(1);
                    loanStatisticDONew.setFinish(0);
                    loanStatisticDONew.setUserid(ascriptionDO.getUpuserid());
                    loanStatisticDONew.setMonth(DateUtil.getMonthFirstDay(date));
                    loanStatisticDONew.setLoanamounttotal(0);
                    loanStatisticDONew.setProfittotal(0.0);
                    loanStatisticDONew.setStatus("正常");
                    loanStatisticService.insert(loanStatisticDONew);
                }else {
                    loanStatisticService.commitAdd(ascriptionDO.getUpuserid(),date);
                }
                System.out.println("添加贷款信息成功");
                return "1";
            }else {
                return "2";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "2";
        }

    }
}
