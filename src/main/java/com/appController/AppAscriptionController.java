package com.appController;

import com.entity.AscriptionDO;
import com.entity.UserDO;
import com.service.AscriptionService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sa on 2017-08-11.
 */
@Controller
@RequestMapping(value = "xqjr/ascription")
public class AppAscriptionController {

    @Autowired
    private AscriptionService ascriptionService;

    @Autowired
    private UserService userService;

    /**
     * 根据userid获取用户的下级
     * @param userid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getDownGradeByUserId")
    public List<UserDO> getDownGradeByUserId(int userid){
        UserDO userDO= new UserDO();
        userDO.setId(userid);
        //TODO 这里可以在以后进行多表查询优化
        //提取用户（M)所有下级用户信息列表（Z)
        List<AscriptionDO> ascriptionDOS = ascriptionService.selectByupGradeUserId(userDO.getId());
        if(ascriptionDOS==null)
            return null;
        //待存储下级用户信息列表
        List<UserDO> downGradeUserDOS =  new ArrayList<UserDO>();
        //如果为空则跳过
        if(ascriptionDOS!=null){
            for(AscriptionDO asc :ascriptionDOS){
                //根据下级downuserid提取用户信息
                UserDO user = userService.selectUserById(asc.getDownuserid());
                //加入到下级用户信息列表中
                downGradeUserDOS.add(user);

            }
            return downGradeUserDOS;
        }
        return null;
    }

    /**
     * 根据用户的userid提取该用户的上级userid
     * @param userid
     * @return
     */
    @RequestMapping(value = "/getUpGradeByUserId")
    @ResponseBody
    public int getUpGradeByUserId(int userid){

        //提取改用户的上级信息
        AscriptionDO ascriptionDO =ascriptionService.selectBydownGradeUserId(userid);
        //定义一个上级变量
        UserDO upGradeUser = new UserDO();
        //若果有上级则提取用户（M)的上级用户信息（N)
        if(ascriptionDO!=null){
            upGradeUser = userService.selectUserById(ascriptionDO.getUpuserid());
            return upGradeUser.getId();
        }
        return  0;
    }
}
