package com.service;

import com.entity.VersionDO;
import com.mapper.VersionDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sa on 2017-09-15.
 */
@Service
public class VersionService {

    @Autowired
    private VersionDOMapper versionDOMapper;

    /**
     * 根据id提取版本信息
     * @param id
     * @return
     */
    public VersionDO selectById(int id){
        try{
            VersionDO versionDO = versionDOMapper.selectByPrimaryKey(id);
            return versionDO;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
