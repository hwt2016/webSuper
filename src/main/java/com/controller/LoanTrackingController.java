package com.controller;

import com.entity.LoanTrackingDO;
import com.service.LoanTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sa on 2017-08-26.
 */
@Controller
@RequestMapping(value = "/loanTracking")
public class LoanTrackingController {

    @Autowired
    private LoanTrackingService loanTrackingService;

    @RequestMapping(value = "/loanTrackingModify",method = RequestMethod.GET)
    public String loanTrackingModify(int loantrackingid, ModelMap modelMap){
        //根据loantrakingID提取该信息
        LoanTrackingDO loanTrackingDO =loanTrackingService.selectLoanTrackingDOById(loantrackingid);
        modelMap.addAttribute("loanTracking",loanTrackingDO);
        return "admin/period/loanTrackingModify";
    }

    @RequestMapping(value = "/loanTrackingModify",method = RequestMethod.POST)
    @ResponseBody
    public String loanTrackingModify(LoanTrackingDO loanTrackingDO){
        if(!loanTrackingService.update(loanTrackingDO))
            return "false";

        return "true";
    }
}
