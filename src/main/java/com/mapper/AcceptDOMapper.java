package com.mapper;

import com.entity.AcceptDO;
import com.entity.AcceptDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcceptDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_accept
     *
     * @mbggenerated
     */
    int countByExample(AcceptDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_accept
     *
     * @mbggenerated
     */
    int deleteByExample(AcceptDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_accept
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_accept
     *
     * @mbggenerated
     */
    int insert(AcceptDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_accept
     *
     * @mbggenerated
     */
    int insertSelective(AcceptDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_accept
     *
     * @mbggenerated
     */
    List<AcceptDO> selectByExample(AcceptDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_accept
     *
     * @mbggenerated
     */
    AcceptDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_accept
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AcceptDO record, @Param("example") AcceptDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_accept
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AcceptDO record, @Param("example") AcceptDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_accept
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AcceptDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_accept
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AcceptDO record);
}