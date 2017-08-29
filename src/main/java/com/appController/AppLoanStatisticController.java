package com.appController;

import com.entity.LoanStatisticDO;
import com.service.LoanStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sa on 2017-08-28.
 */
@Controller
@RequestMapping(value = "/xqjr/loanstatistic")
public class AppLoanStatisticController {

    @Autowired
    private LoanStatisticService loanStatisticService;


    /**
     *根据userid提取该用户负责的所有贷款
     * @param userid
     * @return
     */
    @RequestMapping(value = "/appLoanStatisticGetByUserid")
    @ResponseBody
    public List<LoanStatisticDO> appLoanStatisticGetByUserid(int userid){
        List<LoanStatisticDO> loanStatisticDOS = loanStatisticService.selectByUserId(userid);
        return loanStatisticDOS;
    }
}
