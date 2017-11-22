package com.controller;

import com.em.StatusEnum;
import com.entity.AnnouncementDO;
import com.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sa on 2017-11-13.
 */
@Controller
@RequestMapping(value = "/announcement")
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    //公告查看                announcementRead
    @RequestMapping(value = "/announcementRead",method = RequestMethod.GET)
    public String announcementRead(ModelMap modelMap){
        AnnouncementDO announcementDO =announcementService.announcementRead();
        modelMap.addAttribute("announcementnew",announcementDO);
        return "admin/announcement/announcementRead";
    }

    //协议查看
    @RequestMapping(value = "/protocolRead",method = RequestMethod.GET)
    public String protocolRead(){

        return "admin/announcement/protocolRead";
    }

    //公司简介查看
    @RequestMapping(value = "/aboutUsRead",method = RequestMethod.GET)
    public String aboutUsRead(){

        return "admin/announcement/aboutUsRead";
    }

    //网点查看
    @RequestMapping(value = "/netSiteRead",method = RequestMethod.GET)
    public String netSiteRead(){

        return "admin/announcement/netSiteRead";
    }

    /**
     * 插入一条新的公告信息
     */
    @RequestMapping(value = "/announcementInsert",method = RequestMethod.GET)
    public String announcementInsert(){
        return "admin/announcement/announcementInsert";
    }

    /**
     * 插入一条新的公告信息
     * @param announcementDO（title和content）
     * @return
     */
    @RequestMapping(value = "/announcementInsert",method = RequestMethod.POST)
    @ResponseBody
    public String announcementInsert(AnnouncementDO announcementDO){
        announcementDO.setStatus(StatusEnum.NORMAL.code());
        if(announcementService.announcementInsert(announcementDO))
            return "true";
        else
            return "false";
    }

    @RequestMapping(value = "/announcePicAdd",method = RequestMethod.GET)
    public String announcePicAdd(){

        return "admin/announcement/announcePicAdd";
    }



}
