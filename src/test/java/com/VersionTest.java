package com;

import com.entity.VUserIncomeDO;
import com.service.VUserIncomeService;
import com.service.VersionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by sa on 2017-09-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class VersionTest {

    @Autowired
    private VersionService versionService;

    @Autowired
    VUserIncomeService vUserIncomeService;

    @Test
    public void versionTest(){
        List<VUserIncomeDO> vUserIncomeDO = vUserIncomeService.selectVUserIncomeDO(1);
        System.out.println(vUserIncomeDO.get(0).getPhone() );

    }
}
