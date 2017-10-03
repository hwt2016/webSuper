package com;

import com.entity.VersionDO;
import com.service.VersionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sa on 2017-09-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class VersionTest {

    @Autowired
    private VersionService versionService;

    @Test
    public void versionTest(){
        VersionDO versionDO = versionService.selectById(1);
        System.out.println(versionDO.getSystem()+"  "+versionDO.getType() );
    }
}
