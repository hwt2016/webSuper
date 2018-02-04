package com.service;

import com.em.StatusEnum;
import com.entity.AreaDO;
import com.entity.AreaDOExample;
import com.mapper.AreaDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-05-26.
 * 提供与Area相关的接口
 */
@Service
public class AreaService {

    @Autowired
    private AreaDOMapper areaDOMapper;

    //======插入操作=================================================================================================

    //向Area中插入一条记录
    public boolean insert(AreaDO areaDO){
        areaDO.setCreatetime(new Date(System.currentTimeMillis()));
        areaDO.setUpdatetime(new Date(System.currentTimeMillis()));
        areaDOMapper.insert(areaDO);
        return true;
    }


    //======选取操作=================================================================================================

    //生成Area列表
    public List<AreaDO> selectAll(){
        AreaDOExample areaDOExample =new AreaDOExample();
        areaDOExample.setOrderByClause("id ASC");   //按照id升序排列
        AreaDOExample.Criteria criteria =areaDOExample.createCriteria();
        criteria.andStatusEqualTo(StatusEnum.NORMAL.code());    //选取状态为正常的area
        List<AreaDO> areaDOS=areaDOMapper.selectByExample(areaDOExample);

        return areaDOS;

    }

    //根据Id选取省市区
    public AreaDO selectById(int area_id){
        AreaDO areaDO=areaDOMapper.selectByPrimaryKey(area_id);
        return areaDO;
    }

    //======删除操作=================================================================================================
    //根据id删除相应的Area
    public boolean delete(AreaDO areaDO){
        if(areaDOMapper.deleteByPrimaryKey(areaDO.getId())==1)
            return true;
        else
            return false;
    }

    /**
     * 判断地区是否已经添加
     * @param areaDO
     * @return
     */
    public boolean ifExists(AreaDO areaDO){
        AreaDOExample areaDOExample =new AreaDOExample();
        AreaDOExample.Criteria criteria =areaDOExample.createCriteria();
        criteria.andCityEqualTo(areaDO.getCity());
        criteria.andProvinceEqualTo(areaDO.getProvince());
        criteria.andDistrictEqualTo(areaDO.getDistrict());
        criteria.andStatusEqualTo(StatusEnum.NORMAL.code());    //选取状态为正常的area
        List<AreaDO> areaDOS=areaDOMapper.selectByExample(areaDOExample);
        if(areaDOS.size()!=0&&areaDOS!=null)
            return true;
        else
            return false;
    }

}
