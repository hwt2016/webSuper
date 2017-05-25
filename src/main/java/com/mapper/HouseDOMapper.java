package com.mapper;

import com.entity.HouseDO;
import com.entity.HouseDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_house
     *
     * @mbggenerated
     */
    int countByExample(HouseDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_house
     *
     * @mbggenerated
     */
    int deleteByExample(HouseDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_house
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_house
     *
     * @mbggenerated
     */
    int insert(HouseDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_house
     *
     * @mbggenerated
     */
    int insertSelective(HouseDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_house
     *
     * @mbggenerated
     */
    List<HouseDO> selectByExample(HouseDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_house
     *
     * @mbggenerated
     */
    HouseDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_house
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") HouseDO record, @Param("example") HouseDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_house
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") HouseDO record, @Param("example") HouseDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_house
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(HouseDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_house
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(HouseDO record);
}