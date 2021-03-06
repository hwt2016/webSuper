package com.controller;

import com.em.PeriodStatusEnum;
import com.entity.ReplyDO;
import com.entityConvert.ReplyDOConvert;
import com.entityConvert.ReplyDOConvertMethod;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-06-19.
 * 批复
 */
@Controller
@RequestMapping(value = "/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

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

    //获取批复列表
    @RequestMapping(value = "/replyList",method = RequestMethod.GET)
    public String replyList(ModelMap modelMap){
        //根据批复状态生成审批列表信息，参数 ：批复中
        List<ReplyDO> replyDOS = replyService.selectReplyDOSByStatus(PeriodStatusEnum.reply.code());
        //转换日期格式
        List<ReplyDOConvert> replyDOConverts = new ArrayList<>();
        for(ReplyDO replyDO : replyDOS){
            //将ReplyDO转换成ReplyDOConvert
            ReplyDOConvert replyDOConvert = ReplyDOConvertMethod.replyDOToReplyDOConvert(replyDO);
            replyDOConverts.add(replyDOConvert);
        }
        //注入信息
        modelMap.addAttribute("replys",replyDOConverts);

        return "admin/period/replyList";
    }

    //获取批复更改界面
    //参数为批复表ID
    @RequestMapping(value = "/replyModify",method = RequestMethod.GET)
    public String replyModify(int replyid,ModelMap modelMap){
        //根据replyid提取批复信息
        ReplyDO replyDO = replyService.selectReplyByID(replyid);
        //格式转换
        ReplyDOConvert replyDOConvert = ReplyDOConvertMethod.replyDOToReplyDOConvert(replyDO);
        //注入信息
        modelMap.addAttribute("reply",replyDOConvert);
        return "admin/period/replyModify";
    }

    //批复信息修改
    //参数：批复机构	    批复额度	  批复期限   	批复利率
    //    replyinstitution	replyamount	replydeadline	replyrate
    @RequestMapping(value = "/replyModify",method = RequestMethod.POST)
    @ResponseBody
    public String replyModify(ReplyDOConvert replyDOConvert){
        //格式转换
        ReplyDO replyDO = ReplyDOConvertMethod.replyDOConvertToReplyDO(replyDOConvert);
        //设置更新时间
        replyDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //如果更新信息没有成功
        if(!replyService.update(replyDO))
            return "false";
        return "true";
    }



    /**
     *处理批复信息
     * @param replyid
     * @return true:处理成功 false：处理失败
     */
    @RequestMapping(value = "/replyCope",method = RequestMethod.POST)
    @ResponseBody
    public String replyCope(int replyid){
        String reslut=replyService.replyCope(replyid);
        return reslut;
//        //初始化一个对象
//        ReplyDO replyDO = new ReplyDO();
//        //设置更新的replyid
//        replyDO.setId(replyid);
//        //设置更新的状态：通过
//        replyDO.setStatus(PeriodStatusEnum.pass.code());
//
//        if(replyService.update(replyDO)){
//            replyDO =replyService.selectReplyByID(replyid);
//            //提取该贷款的信息
//            LoanDO loanDO = loanService.selectLoanDOById(replyDO.getLoanid());
//            //获取当前时间
//            Date date = new Date(System.currentTimeMillis());
//            //选取负责该用户的上级信息
//            AscriptionDO ascriptionDO = ascriptionService.selectBydownGradeUserId(loanDO.getUserid());
//            //更新贷款统计记录
//            LoanStatisticDO loanStatisticDO = loanStatisticService.selectByUserIdAndMonthNow(ascriptionDO.getUpuserid(),date);
//            //该贷款的完成笔数加1
//            if (loanStatisticDO==null)
//                return "false";
//            else {
//                loanStatisticService.finishAdd(ascriptionDO.getUpuserid(),date);
//                //更新该笔贷款追踪信息中的完成时间
//                LoanTrackingDO loanTrackingDO = new LoanTrackingDO();
//                loanTrackingDO.setLoanid(loanDO.getId());
//                loanTrackingDO.setMonthfinish(DateUtil.getMonthFirstDay(date));
//                loanTrackingService.update(loanTrackingDO);
//            }
//            //初始化一个贷后监控对象
//            MonitorDO monitorDO = new MonitorDO();
//            //设置审贷ID:loanid
//            monitorDO.setLoanid(replyDO.getLoanid());
//            //设置批复状态：批复中
//            monitorDO.setStatus(PeriodStatusEnum.monitor.code());
//            //更新一条批复记录
//            monitorService.updateByLoanID(monitorDO);
//            return "true";
//        }
//
//        else
//            return "false";
    }

}
