package com.controller;

import com.em.PeriodStatusEnum;
import com.entity.ApprovalDO;
import com.entity.ReplyDO;
import com.entityConvert.ApprovalDOConvert;
import com.entityConvert.ApprovalDOConvertMethod;
import com.service.ApprovalService;
import com.service.ReplyService;
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
 * 审批信息
 */
@Controller
@RequestMapping(value = "/approval")
public class ApprovalController {


    @Autowired
    private ApprovalService approvalService;

    @Autowired
    private ReplyService replyService;

    //获取审批列表
    @RequestMapping(value = "/approvalList",method = RequestMethod.GET)
    public String approvalList(ModelMap modelMap){
        //根据审批状态生成审批列表信息，参数 ：审批中
        List<ApprovalDO> approvalDOS = approvalService.selectApprovalByStatus(PeriodStatusEnum.approval.code());
        //转换日期格式
        List<ApprovalDOConvert> approvalDOConverts = new ArrayList<>();
        for(ApprovalDO approvalDO : approvalDOS){
            //将ApprovalDO转换成ApprovalDOConvert
            ApprovalDOConvert approvalDOConvert = ApprovalDOConvertMethod.approvalDOToApprovalDOConvert(approvalDO);
            approvalDOConverts.add(approvalDOConvert);
        }
        //注入信息
        modelMap.addAttribute("approvals",approvalDOConverts);

        return "admin/period/approvalList";
    }

    //获取审批更改界面
    @RequestMapping(value = "/approvalModify",method = RequestMethod.GET)
    public String approvalModify(int approvalid,ModelMap modelMap){
        //根据approvalid提取审批信息
        ApprovalDO approvalDO = approvalService.selectById(approvalid);
        //格式转换
        ApprovalDOConvert approvalDOConvert = ApprovalDOConvertMethod.approvalDOToApprovalDOConvert(approvalDO);
        //注入信息
        modelMap.addAttribute("approval",approvalDOConvert);
        return "admin/period/approvalModify";
    }

    //更新受理信息
    //参数说明： 融资目标	融资额度	融资期限	融资利率
   //           rongtarget	rongamount	rongdeadline	rongrate
    @RequestMapping(value = "/approvalModify",method = RequestMethod.POST)
    @ResponseBody
    public String approvalModify(ApprovalDOConvert approvalDOConvert){
        //格式转换
        ApprovalDO approvalDO = ApprovalDOConvertMethod.approvalDOConvertToApprovalDO(approvalDOConvert);
        //设置更新时间
        approvalDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //如果更新信息没有成功
        if(!approvalService.update(approvalDO))
            return "false";
        return "true";
    }

    //处理审批信息
    //参数 :审批ID  approvalid
    @RequestMapping(value = "/approvalCope",method = RequestMethod.POST)
    @ResponseBody
    public String approvalCope(int approvalid){
        //初始化一个对象
        ApprovalDO approvalDO = new ApprovalDO();
        //设置更新的approvalid
        approvalDO.setId(approvalid);
        //设置更新的状态：通过
        approvalDO.setStatus(PeriodStatusEnum.pass.code());
        //如果没有更新成功
        if(approvalService.update(approvalDO)){
            approvalDO =approvalService.selectById(approvalid);
            //初始化一个批复对象
            ReplyDO replyDO = new ReplyDO();
            //设置审贷ID:loanid
            replyDO.setLoanid(approvalDO.getLoanid());
            //设置批复状态：批复中
            replyDO.setStatus(PeriodStatusEnum.reply.code());
            //更新一条批复记录
            replyService.updateByLoanID(replyDO);
            return "true";
        }

        else
            return "false";
    }

}
