package com.controller;

import com.em.StatusEnum;
import com.entity.AreaDO;
import com.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-05-26.
 * 与Area（地区表）、相关的操作
 */
@Controller
@RequestMapping(value = "/area")
public class AreaController {


    @Autowired
    private AreaService areaService;



    //向Area中添加一条记录
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String areaAdd(){
        return "area/add";
    }

    /*向Area中添加一条记录
    *传入的参数为省（province),市（city),区域（dist)
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String areaAdd(AreaDO areaDO){
      //System.out.println("province:"+areaDO.getProvince()+" city:"+areaDO.getCity()+"  dist:"+areaDO.getDistrict());
        //TODO 需要验证地区是否已经存在
        //设置状态当前时间
        areaDO.setCreatetime(new Date(System.currentTimeMillis()));
        //设置更新时间
        areaDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //设置状态
        areaDO.setStatus(StatusEnum.NORMAL.code());
        //执行插入操作
        if(!areaService.insert(areaDO))
            return "error";
        return "success";
    }

    /*获取Area(状态正常）列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String arealist(ModelMap modelMap){

        //获取所有列表
        List<AreaDO> areaDOList= areaService.selectAll();
        //注入数据
        modelMap.addAttribute("areas",areaDOList);
        return "area/list";
    }

     /*删除Area表中的某条记录（删除某个地区）
     * 传入的参数为AreaDO(id)
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public String delete(AreaDO areaDO){
        if(areaService.delete(areaDO))
            return "success";
        else
            return "error";

    }

}
