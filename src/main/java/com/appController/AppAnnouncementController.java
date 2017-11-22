package com.appController;

import com.entity.AnnouncementDO;
import com.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sa on 2017-11-17.
 */
@Controller
@RequestMapping(value = "xqjr/announcement")
public class AppAnnouncementController {

    @Autowired
    private AnnouncementService announcementService;




    @RequestMapping(value = "/getAnnounceListByCount",method = RequestMethod.POST)
    @ResponseBody
    public List<AnnouncementDO> getAnnounceListByCount(int count){

        List<AnnouncementDO> announcementDOS = announcementService.announcementReadList(count);

        return announcementDOS;
    }

    @RequestMapping(value = "/getAnnounceList")
    @ResponseBody
    public List<AnnouncementDO> getAnnounceList(){

        List<AnnouncementDO> announcementDOS = announcementService.announcementReadList(3);

        return announcementDOS;
    }
}
