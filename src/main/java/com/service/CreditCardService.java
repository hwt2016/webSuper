package com.service;

import com.em.StatusEnum;
import com.entity.CreditCardDO;
import com.entity.CreditCardDOExample;
import com.mapper.CreditCardDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author sa
 * @Date 2018-01-11
 */
@Service
public class CreditCardService {

    @Autowired
    private CreditCardDOMapper creditCardDOMapper;

    //************** insert  插入*************************************************
    //新增信用卡信息
    @Transactional
    public boolean insert(CreditCardDO creditCardDO){
        try {
            creditCardDO.setStatus(StatusEnum.NORMAL.code());
            creditCardDO.setCreatetime(new Date(System.currentTimeMillis()));
            creditCardDO.setUpdatetime(new Date(System.currentTimeMillis()));
            creditCardDOMapper.insert(creditCardDO);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    //************** select  提取*************************************************

    /**
     * @param userid(用户id)
     * @return 根据用户userid提取该用户名下有列表
     */
    public List<CreditCardDO> selectHousesByUserid(int userid){
        CreditCardDOExample creditCardDOExample = new CreditCardDOExample();
        CreditCardDOExample.Criteria criteria = creditCardDOExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andStatusEqualTo("正常");
        List<CreditCardDO> creditCardDOS = creditCardDOMapper.selectByExample(creditCardDOExample);
        return creditCardDOS;
    }

    //根据信用卡id提取信用卡信息
    public CreditCardDO selectHouseById(int creditcardid){
        CreditCardDO creditCardDO= creditCardDOMapper.selectByPrimaryKey(creditcardid);
        return creditCardDO;
    }

    //************** delete  删除*************************************************

    /**
     *根据creditcardid删除一个信用卡信息
     * @param creditcardid
     * @return
     */
    @Transactional
    public boolean delete(int creditcardid){
        try{
            creditCardDOMapper.deleteByPrimaryKey(creditcardid);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    //************** update  更新*************************************************

    //根据houseid更新房产信息
    @Transactional
    public boolean update(CreditCardDO creditCardDO){
        try {
            creditCardDO.setUpdatetime(new Date(System.currentTimeMillis()));
            creditCardDOMapper.updateByPrimaryKeySelective(creditCardDO);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



}
