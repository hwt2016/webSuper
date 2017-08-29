package com.controller;

import com.entity.LoanDO;
import com.entity.LoanTrackingDO;
import com.entity.UserDO;
import com.service.LoanService;
import com.service.LoanTrackingService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sa on 2017-06-19.
 */
@Controller
@RequestMapping(value = "/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private UserService userService;
    @Autowired
    private LoanTrackingService loanTrackingService;

    //关于该借贷信息的展示
    //传入的参数为 AcceptID
    @RequestMapping(value = "/loanInfoRead",method = RequestMethod.GET)
    public String loanInfoRead(int loanid,ModelMap modelMap){
        //根据loanID提取贷款信息
        LoanDO loanDO = loanService.selectLoanDOById(loanid);
        //根据UserID提取贷款用户的信息
        UserDO userDO = userService.selectUserById(loanDO.getUserid());
        //根据LoanID提取贷款追踪信息
        LoanTrackingDO loanTrackingDO = loanTrackingService.selectLoanTackingDOByLoanId(loanid);

        //注入信息
        modelMap.addAttribute("userInfo",userDO);
        modelMap.addAttribute("loanInfo",loanDO);
        modelMap.addAttribute("loanTacking",loanTrackingDO);

        return  "admin/period/loanInfoRead";
    }
}
