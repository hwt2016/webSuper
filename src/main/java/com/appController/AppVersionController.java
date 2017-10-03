package com.appController;

import com.entity.VersionDO;
import com.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sa on 2017-09-15.
 */
@Controller
@RequestMapping(value = "xqjr/version")
public class AppVersionController {

    @Autowired
    private VersionService versionService;

    @RequestMapping(value = "/appGetVersion")
    @ResponseBody
    public VersionDO appGetVersion(int id){
        VersionDO versionDO = versionService.selectById(id);
        return versionDO;
    }
}
