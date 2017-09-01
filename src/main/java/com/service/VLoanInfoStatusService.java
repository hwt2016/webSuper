package com.service;

import com.entity.VLoanInfoStatusDO;
import com.entity.VLoanInfoStatusDOExample;
import com.mapper.VLoanInfoStatusDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sa on 2017-08-29.
 */
@Service
public class VLoanInfoStatusService {

    @Autowired
    private VLoanInfoStatusDOMapper vLoanInfoStatusDOMapper;

    /**
     * 根据loanid提取贷款追踪详细信息
     * @param loanid
     * @return
     */
    public VLoanInfoStatusDO selectByLoanId(int loanid){
        VLoanInfoStatusDOExample vLoanInfoStatusDOExample = new VLoanInfoStatusDOExample();
        VLoanInfoStatusDOExample.Criteria criteria =vLoanInfoStatusDOExample.createCriteria();
        criteria.andIdEqualTo(loanid);
        List<VLoanInfoStatusDO> vLoanInfoStatusDOS = vLoanInfoStatusDOMapper.selectByExample(vLoanInfoStatusDOExample);
        if(vLoanInfoStatusDOS.size()!=0)
            return vLoanInfoStatusDOS.get(0);
        else
            return null;
    }
}
