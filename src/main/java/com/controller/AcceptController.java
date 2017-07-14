package com.controller;

import com.em.PeriodStatusEnum;
import com.entity.AcceptDO;
import com.entity.ApprovalDO;
import com.entity.LoanDO;
import com.entity.UserDO;
import com.entityConvert.AcceptDOConvert;
import com.entityConvert.AcceptDOConvertMethod;
import com.service.AcceptService;
import com.service.ApprovalService;
import com.service.LoanService;
import com.service.UserService;
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
 * Created by sa on 2017-06-18.
 */
@Controller
@RequestMapping(value = "/accept")
public class AcceptController {

    @Autowired
    private AcceptService acceptService;

    @Autowired
    private LoanService loanService;

    @Autowired
    private UserService userService;

    @Autowired
    private ApprovalService approvalService;

    //提取所有的受理信息列表
    @RequestMapping(value = "/acceptList",method = RequestMethod.GET)
    public String acceptList(ModelMap modelMap){
        //根据受理状态生成受理信息列表（参数时受理中）
        List<AcceptDO> acceptDOList = acceptService.selectAcceptListByStatus(PeriodStatusEnum.accept.code());
        //格式转换（把时间转换成字符串）
        List<AcceptDOConvert> acceptDOConvertList= new ArrayList<AcceptDOConvert>();
        for(AcceptDO acceptDO : acceptDOList){
            //将AcceptDO转换成AcceptDOConvert
            AcceptDOConvert acceptDOConvert = AcceptDOConvertMethod.acceptDOToAcceptDOConvert(acceptDO);
            System.out.println(acceptDOConvert.getDealmanagername());
            acceptDOConvertList.add(acceptDOConvert);
        }
        modelMap.addAttribute("accepts",acceptDOConvertList);

        return "admin/period/acceptList";
    }

    //关于该借贷信息的展示
    //传入的参数为 AcceptID
    @RequestMapping(value = "/acceptInfoRead",method = RequestMethod.GET)
    public String acceptInfoRead(int acceptid,ModelMap modelMap){
        //根据acceptID提取受理信息
        AcceptDO acceptDO = acceptService.selectAcceptDOById(acceptid);
        //根据LoanID提取贷款信息
        LoanDO loanDO = loanService.selectLoanDOById(acceptDO.getLoanid());
        //根据UserID提取贷款用户的信息
        UserDO userDO = userService.selectUserById(loanDO.getUserid());
        //注入信息
        modelMap.addAttribute("userInfo",userDO);
        modelMap.addAttribute("loanInfo",loanDO);

        return  "admin/period/acceptInfoRead";
    }

    //获取受理意见更改界面
    @RequestMapping(value = "/acceptModify",method = RequestMethod.GET)
    public String acceptModify(int acceptid,ModelMap modelMap){
        //根据acceptid提取受理信息
        AcceptDO acceptDO = acceptService.selectAcceptDOById(acceptid);

        modelMap.addAttribute("accept",acceptDO);
        return "admin/period/acceptModify";
    }

    //更新受理信息
    //参数说明：受理意见:dealview

    @RequestMapping(value = "/acceptModify",method = RequestMethod.POST)
    @ResponseBody
    public String acceptModify(AcceptDO acceptDO){
        //设置更新时间
        acceptDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //如果更新信息没有成功
        if(!acceptService.update(acceptDO))
            return "false";
        return "true";
    }

    //处理受理信息
    //参数 :受理ID  acceptid
    @RequestMapping(value = "/acceptCope",method = RequestMethod.POST)
    @ResponseBody
    public String acceptCope(int acceptid){
        //初始化一个对象
        AcceptDO acceptDO = new AcceptDO();
        //设置更新的appectid
        acceptDO.setId(acceptid);
        //设置更新的状态：通过
        acceptDO.setStatus(PeriodStatusEnum.pass.code());
        //如果没有更新成功
        if(acceptService.update(acceptDO)){
            acceptDO =acceptService.selectAcceptDOById(acceptid);
            //初始化一个审批对象
            ApprovalDO approvalDO = new ApprovalDO();
            //设置审批状态：审批中
            approvalDO.setStatus(PeriodStatusEnum.approval.code());
            //设置审贷ID:loanid
            approvalDO.setLoanid(acceptDO.getLoanid());
            //设置创建时间
            approvalDO.setCreatetime(new Date(System.currentTimeMillis()));
            //设置更新时间
            approvalDO.setUpdatetime(new Date(System.currentTimeMillis()));
            //新增一条审批记录
            approvalService.insert(approvalDO);
            return "true";
        }

        else
            return "false";
    }



}
