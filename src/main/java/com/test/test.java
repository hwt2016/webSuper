package com.test;

import com.entity.LoanStatisticDO;
import com.service.LoanStatisticService;
import com.service.LoanTrackingService;
import com.service.VLoanInfoStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by sa on 2017-08-27.
 */
@Controller
public class test {
    @Autowired
    private LoanTrackingService loanTrackingService;

    @Autowired
    private LoanStatisticService loanStatisticService;

    @Autowired
    private VLoanInfoStatusService vLoanInfoStatusService;
//
//    @Autowired
//    private LoanTrackingService loanTrackingService;
//
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        System.out.println("进入");
        LoanStatisticDO loanStatisticDO= loanStatisticService.selectByUserIdAndMonthNow(1,date);
        if(loanStatisticDO==null){
            System.out.println("空空");
        }

//        Date date = loanTrackingService.apploanTrackingEarlyDateByUserID(2);
////        System.out.println("日期为"+date);
//        VLoanInfoStatusDO vLoanInfoStatusDO = vLoanInfoStatusService.selectByLoanId(955);
//        System.out.print(vLoanInfoStatusDO.getRealname());

        return "1";
    }

}
