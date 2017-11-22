package com.service;

import com.entity.AnnouncementDO;
import com.entity.AnnouncementDOExample;
import com.mapper.AnnouncementDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-11-13.
 */
@Service
public class AnnouncementService {

    @Autowired
    AnnouncementDOMapper announcementDOMapper;

    /**
     * 提取最新公告信息
     * @return
     */
    public AnnouncementDO announcementRead(){
        AnnouncementDOExample announcementDOExample=new AnnouncementDOExample();
        AnnouncementDOExample.Criteria criteria = announcementDOExample.createCriteria();
        announcementDOExample.setOrderByClause("id DESC");
        List<AnnouncementDO> announcementDOS = announcementDOMapper.selectByExample(announcementDOExample);
        if(announcementDOS!=null)
            return announcementDOS.get(0);

        return null;
    }

    /**
     * 获取最新的count公告
     * @param count
     * @return
     */
    public List<AnnouncementDO> announcementReadList(int count){
        AnnouncementDOExample announcementDOExample=new AnnouncementDOExample();
        AnnouncementDOExample.Criteria criteria = announcementDOExample.createCriteria();
        announcementDOExample.setLimitStart(0);
        announcementDOExample.setLimitEnd(count);
        announcementDOExample.setOrderByClause("id DESC");
        List<AnnouncementDO> announcementDOS = announcementDOMapper.selectByExample(announcementDOExample);
        if(announcementDOS!=null)
            return announcementDOS;

        return null;
    }


    /**
     *根据announcementd修改公告信息
     * @param announcementDO
     * @return
     */
    public boolean announcementUpdate(AnnouncementDO announcementDO){
        announcementDO.setUpdatetime(new Date(System.currentTimeMillis()));
        announcementDOMapper.updateByPrimaryKeySelective(announcementDO);
        return true;

    }

    /**
     * 插入一条公告信息
     * @param announcementDO
     * @return
     */
    public boolean announcementInsert(AnnouncementDO announcementDO){
        announcementDO.setCreatetime(new Date(System.currentTimeMillis()));
        announcementDO.setUpdatetime(new Date(System.currentTimeMillis()));
        try{
            announcementDOMapper.insert(announcementDO);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
