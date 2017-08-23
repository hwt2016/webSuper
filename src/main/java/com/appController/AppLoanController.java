package com.appController;

import com.entity.AcceptDO;
import com.entity.LoanDO;
import com.service.AcceptService;
import com.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sa on 2017-08-19.
 */
@Controller
@RequestMapping(value = "/xqjr/loan")
public class AppLoanController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private AcceptService acceptService;

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
        int loanNewID= loanService.insertLoanDO(loanDO);
        if(loanNewID>0){
            AcceptDO acceptDO = new AcceptDO();
            acceptDO.setStatus("受理中");
            acceptDO.setLoanid(loanDO.getId());
            acceptService.insert(acceptDO);
            return "1";
        }

        return "2";

    }
}
