package com.mapper;

import com.entity.LoanDO;
import com.entity.LoanDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoanDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_loan
     *
     * @mbggenerated
     */
    int countByExample(LoanDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_loan
     *
     * @mbggenerated
     */
    int deleteByExample(LoanDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_loan
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_loan
     *
     * @mbggenerated
     */
    int insert(LoanDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_loan
     *
     * @mbggenerated
     */
    int insertSelective(LoanDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_loan
     *
     * @mbggenerated
     */
    List<LoanDO> selectByExample(LoanDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_loan
     *
     * @mbggenerated
     */
    LoanDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_loan
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") LoanDO record, @Param("example") LoanDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_loan
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") LoanDO record, @Param("example") LoanDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_loan
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LoanDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_loan
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LoanDO record);
}