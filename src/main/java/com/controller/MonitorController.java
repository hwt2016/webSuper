package com.controller;

import com.em.PeriodStatusEnum;
import com.entity.MonitorDO;
import com.entityConvert.MonitorDOConvert;
import com.entityConvert.MonitorDOConvertMethod;
import com.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-06-19.
 * 贷后监控
 */
@Controller
@RequestMapping(value = "/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    //获取贷后监控列表
    @RequestMapping(value = "/monitorList",method = RequestMethod.GET)
    public String monitorList(ModelMap modelMap){
        //根据批复状态生成审批列表信息，参数 ：批复中
        List<MonitorDO> monitorDOS = monitorService.selectMonitorDOSByStatus(PeriodStatusEnum.monitor.code());
        //转换日期格式
        List<MonitorDOConvert> monitorDOConverts = new ArrayList<>();
        for(MonitorDO monitorDO : monitorDOS){
            //将ReplyDO转换成ReplyDOConvert
            MonitorDOConvert monitorDOConvert = MonitorDOConvertMethod.MonitorDOToMonitorDOConvert(monitorDO);
            monitorDOConverts.add(monitorDOConvert);
        }
        //注入信息
        modelMap.addAttribute("monitors",monitorDOConverts);

        return "admin/period/monitorList";
    }

    //获取贷后监控更改界面
    //参数为贷后监控表ID
    @RequestMapping(value = "/monitorModify",method = RequestMethod.GET)
    public String monitorModify(int monitorid,ModelMap modelMap){
        //根据monitorid提取贷后监控信息
        MonitorDO monitorDO = monitorService.selectMonitorById(monitorid);
        //格式转换
        MonitorDOConvert monitorDOConvert = MonitorDOConvertMethod.MonitorDOToMonitorDOConvert(monitorDO);
        //注入信息
        modelMap.addAttribute("monitor",monitorDOConvert);
        return "admin/period/monitorModify";
    }

    //贷后监控信息修改
    //参数说明：还款方式	还款金额	还款日期	业务终结日期
    //         paymethod	payamount	paydate	endofbusiness

    @RequestMapping(value = "/monitorModify",method = RequestMethod.POST)
    @ResponseBody
    public String monitorModify(MonitorDOConvert monitorDOConvert){
        //格式转换
        MonitorDO monitorDO = MonitorDOConvertMethod.MonitorDOConvertToMonitorDO(monitorDOConvert);
        //设置更新时间
        monitorDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //如果更新信息没有成功
        if(!monitorService.update(monitorDO))
            return "false";
        return "true";
    }

}
