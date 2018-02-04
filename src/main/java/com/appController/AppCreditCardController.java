package com.appController;

import com.entity.CreditCardDO;
import com.service.CreditCardService;
import com.service.UserService;
import com.util.JsonConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * @Author sa
 * @Date 2018-01-11
 */
@Controller
@RequestMapping(value = "/xqjr/creditcard")
public class AppCreditCardController {

    @Autowired
    private CreditCardService creditCardService;
    @Autowired
    private UserService userService;

    /**
     *根据用户id获取他的所有信用卡信息
     * @param userid （用户id)
     * @return（信用卡信息列表）
     */
    @ResponseBody
    @RequestMapping(value = "/appCreditCardsGetByUserId",method = RequestMethod.GET)
    public List<CreditCardDO> appCreditCardGetByUserId(Integer userid){
        List<CreditCardDO> creditCardDOList = creditCardService.selectHousesByUserid(userid);
        return creditCardDOList;
    }

    /**
     *更新或添加信用卡信息
     * @param jsonCreditCards (信用卡列表）
     * @return（0：待更新的信用卡列表为空 1：更新或添加成功 2：添加异常)
     */
    @ResponseBody
    @RequestMapping(value = "/appCreditCardsUpadteALL",method = RequestMethod.POST)
    public String appCreditCardsUpadteALL(String jsonCreditCards){
        System.out.println("更新所有信用卡信息");
        if(jsonCreditCards==null||jsonCreditCards.equals(""))
            return "0";
        List<CreditCardDO> houseDOList= null;
        try {
            houseDOList = JsonConvert.jsonToObjectList(jsonCreditCards,CreditCardDO.class);
            for(CreditCardDO creditCardDO:houseDOList){
                if(creditCardDO.getId()==null||creditCardDO.getId().equals(""))
                    creditCardService.insert(creditCardDO);
                else
                    creditCardService.update(creditCardDO);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "2";
        }
        return "1";
    }

    /**
     * 添加一张信用卡信息
     * @param creditCardDO
     * @return （0：待更新的房产列表为空 1：更新或添加成功 2：添加异常)
     */
    @RequestMapping(value = "/appCreditCardAdd",method = RequestMethod.POST)
    @ResponseBody
    public String appCreditCardAdd(@RequestBody CreditCardDO creditCardDO){
        System.out.println("添加一个新的信用卡");
        if(creditCardDO.getUserid()==null||creditCardDO.getUserid().equals(""))
            return "0";
        int userid=creditCardDO.getUserid();
        if(userService.IfExistsByUserId(userid)){
            creditCardService.insert(creditCardDO);
            return "1";
        }else{
            return "2";
        }
    }

    /**
     * 根据creditid删除信用卡信息
     * @param creditcardid
     * @return 1正常删除  2删除异常
     */
    @RequestMapping(value = "/appCreditCardDel",method = RequestMethod.POST)
    @ResponseBody
    public String appCreditCardDel(int creditcardid){
        System.out.println("删除一个信用卡");
        if(creditCardService.delete(creditcardid))
            return "1";
        else
            return "2";

    }
}
