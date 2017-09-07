package com.appController;

import com.em.PeriodStatusEnum;
import com.entity.*;
import com.service.*;
import com.util.DateUtil;
import com.util.JsonConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by sa on 2017-08-19.
 */
@Controller
@RequestMapping(value = "/xqjr/loan")
public class AppLoanController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoanService loanService;

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

    /**
     * 新增一条贷款信息
     * @param loanDO
     * @return（0：新增贷款信息为空 1：更新或添加成功 2：添加异常)
     */
    @RequestMapping(value = "/appLoanAdd")
    @ResponseBody
    public String appLoanAdd(@RequestBody LoanDO loanDO){
        if(loanDO==null||loanDO.getUserid()==null||loanDO.getUserid().equals(""))
            return "0";
        //如果插入成功，返回当前改变的行数，插入一条记录，所以影响的行数为1
        int loanNewID= loanService.insertLoanDO(loanDO);//插入成功loanNewID=1
        //TODO 这里对数据库的操作太多，最好做成一个存储过程
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


            return "1";
        }

        return "2";
    }


    /**
     * 新增一条贷款信息
     * @param jsonLoan
     * @return（0：新增贷款信息为空 1：更新或添加成功 2：添加异常)
     */
    @RequestMapping(value = "/appLoanAddByOS",method = RequestMethod.POST)
    @ResponseBody
    public String appLoanAddByOS(String jsonLoan){
        if(jsonLoan.equals("")||jsonLoan.length()==0||jsonLoan==null)
            return "0";
        LoanDO loanDO= JsonConvert.jsonToObject(jsonLoan,LoanDO.class);
        //如果插入成功，返回当前改变的行数，插入一条记录，所以影响的行数为1
        int loanNewID= loanService.insertLoanDO(loanDO);//插入成功loanNewID=1
        //TODO 这里对数据库的操作太多，最好做成一个存储过程
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


            return "1";
        }

        return "2";
    }

}
