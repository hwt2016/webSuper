package com.service;

import com.entity.VUserIncomeDO;
import com.entity.VUserIncomeDOExample;
import com.mapper.VUserIncomeDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sa on 2017-09-07.
 */
@Service
public class VUserIncomeService {

    @Autowired
    private VUserIncomeDOMapper vUserIncomeDOMapper;


    /**
     * 根据上级upuserid找出所有下级信息
     * @param upuserid
     * @return
     */
    public List<VUserIncomeDO> selectVUserIncomeDO(int upuserid){
        VUserIncomeDOExample vUserIncomeDOExample = new VUserIncomeDOExample();
        VUserIncomeDOExample.Criteria criteria = vUserIncomeDOExample.createCriteria();
        criteria.andUpuseridEqualTo(upuserid);
        List<VUserIncomeDO> vUserIncomeDOList =vUserIncomeDOMapper.selectByExample(vUserIncomeDOExample);
        if(vUserIncomeDOList.size()==0)
            return null;
        else
            return vUserIncomeDOList;
    }
}
