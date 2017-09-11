package com.appController;

import com.entity.VUserIncomeDO;
import com.service.VUserIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sa on 2017-09-07.
 */
@Controller
@RequestMapping(value = "/xqjr/vuserincome")
public class AppVUserIncomeController {

    @Autowired
    VUserIncomeService vUserIncomeService;


    /**
     * 根据上级upuserid提取所有下级用户收入信息
     * @param upuserid
     * @return
     */
    @RequestMapping(value = "/appUserIncomeGetByUserId",method = RequestMethod.GET)
    @ResponseBody
    public List<VUserIncomeDO> appUserIncomeGetByUserId(int upuserid){
        List<VUserIncomeDO> vUserIncomeDOList = vUserIncomeService.selectVUserIncomeDO(upuserid);
        if(vUserIncomeDOList!=null)
            return vUserIncomeDOList;
        else
            return null;
    }

}
