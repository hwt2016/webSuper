package com.service;

import com.entity.LoanDO;
import com.mapper.LoanDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sa on 2017-06-18.
 * 贷款接口表
 */
@Service
public class LoanService {

    @Autowired
    private LoanDOMapper loanDOMapper;

    //************** select  提取*************************************************
    //根据贷款ID提取贷款信息
    public LoanDO selectLoanDOById(int loanid){
        LoanDO loanDO = loanDOMapper.selectByPrimaryKey(loanid);
        return loanDO;
    }

}
