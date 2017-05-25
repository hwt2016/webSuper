package com.mapper;

import com.entity.VehicleDO;
import com.entity.VehicleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_vehicle
     *
     * @mbggenerated
     */
    int countByExample(VehicleDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_vehicle
     *
     * @mbggenerated
     */
    int deleteByExample(VehicleDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_vehicle
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_vehicle
     *
     * @mbggenerated
     */
    int insert(VehicleDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_vehicle
     *
     * @mbggenerated
     */
    int insertSelective(VehicleDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_vehicle
     *
     * @mbggenerated
     */
    List<VehicleDO> selectByExample(VehicleDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_vehicle
     *
     * @mbggenerated
     */
    VehicleDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_vehicle
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") VehicleDO record, @Param("example") VehicleDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_vehicle
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") VehicleDO record, @Param("example") VehicleDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_vehicle
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(VehicleDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_vehicle
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(VehicleDO record);
}