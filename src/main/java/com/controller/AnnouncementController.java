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

import java.util.List;

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


    //公司IOS简介查看
    @RequestMapping(value = "/aboutUsReadIOS",method = RequestMethod.GET)
    public String aboutUsReadIOS(){

        return "admin/announcement/aboutUsReadIOS";
    }

    //客户隐私政策
    @RequestMapping(value = "/customerPrivatePolicy",method = RequestMethod.GET)
    public String customerPrivatePolicy(){

        return "admin/announcement/customerPrivatePolicy";
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

    //TODO 公告图片管理
    @RequestMapping(value = "/announcePicAdd",method = RequestMethod.GET)
    public String announcePicAdd(){

        return "admin/announcement/announcePicAdd";
    }

    //获取最新三条公告
    @RequestMapping(value = "/announcementReadList",method = RequestMethod.GET)
    public String announcementReadList(ModelMap modelMap){
        List<AnnouncementDO> announcementDOS = announcementService.announcementReadList(3);
        modelMap.addAttribute("announcementDOS",announcementDOS);
        return "admin/announcement/announcementReadList";
    }

    /**
     *删除公告
     * @param id (公告id :announcementid)
     * @return 删除成功  删除失败
     */
    @RequestMapping(value = "/announcemntDel",method = RequestMethod.POST)
    @ResponseBody
    public String announcemntDel(int id){
        if(announcementService.announcemntDel(id)){
            return "成功";
        }
        return "失败";
    }


}
