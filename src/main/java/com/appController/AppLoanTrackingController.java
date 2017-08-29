package com.appController;



import com.entity.LoanTrackingDO;
import com.service.LoanTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sa on 2017-08-26.
 */
@Controller
@RequestMapping(value = "/xqjr/loantracking")
public class AppLoanTrackingController {

    @Autowired
    private LoanTrackingService loanTrackingService;

    /**
     * 根据upuserid和monthcommit提取贷款追踪信息
     * @param upuserid(推荐人userid）
     * @param monthcommit
     * @return
     */
    @RequestMapping(value = "/appLoanTrackingSearchByMonthCommit")
    @ResponseBody
    public List<LoanTrackingDO> appLoanTrackingSearchByMonthCommit(int upuserid, String monthcommit){
        List<LoanTrackingDO> loanTrackingDOS = loanTrackingService.selectLoanTrackingDOSByUpUserIdAndMonthCommit(upuserid,monthcommit);
        return loanTrackingDOS;
    }

    @RequestMapping(value = "/appLoanTrackingSearchByMonthFinish")
    @ResponseBody
    public List<LoanTrackingDO> appLoanTrackingSearchByMonthFinish(int upuserid, String monthfinish){
        if(monthfinish==null){
            return null;
        }
        List<LoanTrackingDO> loanTrackingDOS = loanTrackingService.selectLoanTrackingDOSByUpUserIdAndMonthFinish(upuserid,monthfinish);
        return loanTrackingDOS;
    }



}
