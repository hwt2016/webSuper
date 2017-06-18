package com.mapper;

import com.entity.MonitorDO;
import com.entity.MonitorDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitorDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_monitor
     *
     * @mbggenerated
     */
    int countByExample(MonitorDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_monitor
     *
     * @mbggenerated
     */
    int deleteByExample(MonitorDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_monitor
     *
     * @mbggenerated
     */
    int insert(MonitorDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_monitor
     *
     * @mbggenerated
     */
    int insertSelective(MonitorDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_monitor
     *
     * @mbggenerated
     */
    List<MonitorDO> selectByExample(MonitorDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_monitor
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MonitorDO record, @Param("example") MonitorDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_monitor
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MonitorDO record, @Param("example") MonitorDOExample example);
}