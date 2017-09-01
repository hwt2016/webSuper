package com.appController;

import com.entity.VLoanInfoStatusDO;
import com.service.VLoanInfoStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sa on 2017-08-29.
 */
@Controller
@RequestMapping(value = "/xqjr/vloaninfo")
public class AppVLoanInfoStatusController {

    @Autowired
    private VLoanInfoStatusService vLoanInfoStatusService;

    /**
     * 根据loanId提取信息
     * @param loanid
     * @return
     */
    @RequestMapping(value = "/appgetVLoanInfoStatusByLoanId")
    @ResponseBody
    public VLoanInfoStatusDO appgetVLoanInfoStatusByLoanId(int loanid){
        VLoanInfoStatusDO vLoanInfoStatusDO = vLoanInfoStatusService.selectByLoanId(loanid);
        return vLoanInfoStatusDO;
    }
}
