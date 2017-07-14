package com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ApprovalDOExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    protected Integer limitStart;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    protected Integer limitEnd;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public ApprovalDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLoanidIsNull() {
            addCriterion("loanid is null");
            return (Criteria) this;
        }

        public Criteria andLoanidIsNotNull() {
            addCriterion("loanid is not null");
            return (Criteria) this;
        }

        public Criteria andLoanidEqualTo(Integer value) {
            addCriterion("loanid =", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidNotEqualTo(Integer value) {
            addCriterion("loanid <>", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidGreaterThan(Integer value) {
            addCriterion("loanid >", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("loanid >=", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidLessThan(Integer value) {
            addCriterion("loanid <", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidLessThanOrEqualTo(Integer value) {
            addCriterion("loanid <=", value, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidIn(List<Integer> values) {
            addCriterion("loanid in", values, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidNotIn(List<Integer> values) {
            addCriterion("loanid not in", values, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidBetween(Integer value1, Integer value2) {
            addCriterion("loanid between", value1, value2, "loanid");
            return (Criteria) this;
        }

        public Criteria andLoanidNotBetween(Integer value1, Integer value2) {
            addCriterion("loanid not between", value1, value2, "loanid");
            return (Criteria) this;
        }

        public Criteria andRongtargetIsNull() {
            addCriterion("rongtarget is null");
            return (Criteria) this;
        }

        public Criteria andRongtargetIsNotNull() {
            addCriterion("rongtarget is not null");
            return (Criteria) this;
        }

        public Criteria andRongtargetEqualTo(String value) {
            addCriterion("rongtarget =", value, "rongtarget");
            return (Criteria) this;
        }

        public Criteria andRongtargetNotEqualTo(String value) {
            addCriterion("rongtarget <>", value, "rongtarget");
            return (Criteria) this;
        }

        public Criteria andRongtargetGreaterThan(String value) {
            addCriterion("rongtarget >", value, "rongtarget");
            return (Criteria) this;
        }

        public Criteria andRongtargetGreaterThanOrEqualTo(String value) {
            addCriterion("rongtarget >=", value, "rongtarget");
            return (Criteria) this;
        }

        public Criteria andRongtargetLessThan(String value) {
            addCriterion("rongtarget <", value, "rongtarget");
            return (Criteria) this;
        }

        public Criteria andRongtargetLessThanOrEqualTo(String value) {
            addCriterion("rongtarget <=", value, "rongtarget");
            return (Criteria) this;
        }

        public Criteria andRongtargetLike(String value) {
            addCriterion("rongtarget like", value, "rongtarget");
            return (Criteria) this;
        }

        public Criteria andRongtargetNotLike(String value) {
            addCriterion("rongtarget not like", value, "rongtarget");
            return (Criteria) this;
        }

        public Criteria andRongtargetIn(List<String> values) {
            addCriterion("rongtarget in", values, "rongtarget");
            return (Criteria) this;
        }

        public Criteria andRongtargetNotIn(List<String> values) {
            addCriterion("rongtarget not in", values, "rongtarget");
            return (Criteria) this;
        }

        public Criteria andRongtargetBetween(String value1, String value2) {
            addCriterion("rongtarget between", value1, value2, "rongtarget");
            return (Criteria) this;
        }

        public Criteria andRongtargetNotBetween(String value1, String value2) {
            addCriterion("rongtarget not between", value1, value2, "rongtarget");
            return (Criteria) this;
        }

        public Criteria andRongamountIsNull() {
            addCriterion("rongamount is null");
            return (Criteria) this;
        }

        public Criteria andRongamountIsNotNull() {
            addCriterion("rongamount is not null");
            return (Criteria) this;
        }

        public Criteria andRongamountEqualTo(Double value) {
            addCriterion("rongamount =", value, "rongamount");
            return (Criteria) this;
        }

        public Criteria andRongamountNotEqualTo(Double value) {
            addCriterion("rongamount <>", value, "rongamount");
            return (Criteria) this;
        }

        public Criteria andRongamountGreaterThan(Double value) {
            addCriterion("rongamount >", value, "rongamount");
            return (Criteria) this;
        }

        public Criteria andRongamountGreaterThanOrEqualTo(Double value) {
            addCriterion("rongamount >=", value, "rongamount");
            return (Criteria) this;
        }

        public Criteria andRongamountLessThan(Double value) {
            addCriterion("rongamount <", value, "rongamount");
            return (Criteria) this;
        }

        public Criteria andRongamountLessThanOrEqualTo(Double value) {
            addCriterion("rongamount <=", value, "rongamount");
            return (Criteria) this;
        }

        public Criteria andRongamountIn(List<Double> values) {
            addCriterion("rongamount in", values, "rongamount");
            return (Criteria) this;
        }

        public Criteria andRongamountNotIn(List<Double> values) {
            addCriterion("rongamount not in", values, "rongamount");
            return (Criteria) this;
        }

        public Criteria andRongamountBetween(Double value1, Double value2) {
            addCriterion("rongamount between", value1, value2, "rongamount");
            return (Criteria) this;
        }

        public Criteria andRongamountNotBetween(Double value1, Double value2) {
            addCriterion("rongamount not between", value1, value2, "rongamount");
            return (Criteria) this;
        }

        public Criteria andRongdeadlineIsNull() {
            addCriterion("rongdeadline is null");
            return (Criteria) this;
        }

        public Criteria andRongdeadlineIsNotNull() {
            addCriterion("rongdeadline is not null");
            return (Criteria) this;
        }

        public Criteria andRongdeadlineEqualTo(Date value) {
            addCriterionForJDBCDate("rongdeadline =", value, "rongdeadline");
            return (Criteria) this;
        }

        public Criteria andRongdeadlineNotEqualTo(Date value) {
            addCriterionForJDBCDate("rongdeadline <>", value, "rongdeadline");
            return (Criteria) this;
        }

        public Criteria andRongdeadlineGreaterThan(Date value) {
            addCriterionForJDBCDate("rongdeadline >", value, "rongdeadline");
            return (Criteria) this;
        }

        public Criteria andRongdeadlineGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rongdeadline >=", value, "rongdeadline");
            return (Criteria) this;
        }

        public Criteria andRongdeadlineLessThan(Date value) {
            addCriterionForJDBCDate("rongdeadline <", value, "rongdeadline");
            return (Criteria) this;
        }

        public Criteria andRongdeadlineLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rongdeadline <=", value, "rongdeadline");
            return (Criteria) this;
        }

        public Criteria andRongdeadlineIn(List<Date> values) {
            addCriterionForJDBCDate("rongdeadline in", values, "rongdeadline");
            return (Criteria) this;
        }

        public Criteria andRongdeadlineNotIn(List<Date> values) {
            addCriterionForJDBCDate("rongdeadline not in", values, "rongdeadline");
            return (Criteria) this;
        }

        public Criteria andRongdeadlineBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rongdeadline between", value1, value2, "rongdeadline");
            return (Criteria) this;
        }

        public Criteria andRongdeadlineNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rongdeadline not between", value1, value2, "rongdeadline");
            return (Criteria) this;
        }

        public Criteria andRongrateIsNull() {
            addCriterion("rongrate is null");
            return (Criteria) this;
        }

        public Criteria andRongrateIsNotNull() {
            addCriterion("rongrate is not null");
            return (Criteria) this;
        }

        public Criteria andRongrateEqualTo(Double value) {
            addCriterion("rongrate =", value, "rongrate");
            return (Criteria) this;
        }

        public Criteria andRongrateNotEqualTo(Double value) {
            addCriterion("rongrate <>", value, "rongrate");
            return (Criteria) this;
        }

        public Criteria andRongrateGreaterThan(Double value) {
            addCriterion("rongrate >", value, "rongrate");
            return (Criteria) this;
        }

        public Criteria andRongrateGreaterThanOrEqualTo(Double value) {
            addCriterion("rongrate >=", value, "rongrate");
            return (Criteria) this;
        }

        public Criteria andRongrateLessThan(Double value) {
            addCriterion("rongrate <", value, "rongrate");
            return (Criteria) this;
        }

        public Criteria andRongrateLessThanOrEqualTo(Double value) {
            addCriterion("rongrate <=", value, "rongrate");
            return (Criteria) this;
        }

        public Criteria andRongrateIn(List<Double> values) {
            addCriterion("rongrate in", values, "rongrate");
            return (Criteria) this;
        }

        public Criteria andRongrateNotIn(List<Double> values) {
            addCriterion("rongrate not in", values, "rongrate");
            return (Criteria) this;
        }

        public Criteria andRongrateBetween(Double value1, Double value2) {
            addCriterion("rongrate between", value1, value2, "rongrate");
            return (Criteria) this;
        }

        public Criteria andRongrateNotBetween(Double value1, Double value2) {
            addCriterion("rongrate not between", value1, value2, "rongrate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table d_approval
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table d_approval
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}