package com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeriodDOExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_period
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_period
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_period
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_period
     *
     * @mbggenerated
     */
    protected Integer limitStart;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_period
     *
     * @mbggenerated
     */
    protected Integer limitEnd;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_period
     *
     * @mbggenerated
     */
    public PeriodDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_period
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_period
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_period
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_period
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_period
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_period
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_period
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
     * This method corresponds to the database table d_period
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
     * This method corresponds to the database table d_period
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_period
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
     * This method corresponds to the database table d_period
     *
     * @mbggenerated
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_period
     *
     * @mbggenerated
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_period
     *
     * @mbggenerated
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_period
     *
     * @mbggenerated
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table d_period
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
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

        public Criteria andAcceptidIsNull() {
            addCriterion("acceptid is null");
            return (Criteria) this;
        }

        public Criteria andAcceptidIsNotNull() {
            addCriterion("acceptid is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptidEqualTo(Integer value) {
            addCriterion("acceptid =", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotEqualTo(Integer value) {
            addCriterion("acceptid <>", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidGreaterThan(Integer value) {
            addCriterion("acceptid >", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidGreaterThanOrEqualTo(Integer value) {
            addCriterion("acceptid >=", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLessThan(Integer value) {
            addCriterion("acceptid <", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLessThanOrEqualTo(Integer value) {
            addCriterion("acceptid <=", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidIn(List<Integer> values) {
            addCriterion("acceptid in", values, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotIn(List<Integer> values) {
            addCriterion("acceptid not in", values, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidBetween(Integer value1, Integer value2) {
            addCriterion("acceptid between", value1, value2, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotBetween(Integer value1, Integer value2) {
            addCriterion("acceptid not between", value1, value2, "acceptid");
            return (Criteria) this;
        }

        public Criteria andApprovalidIsNull() {
            addCriterion("approvalid is null");
            return (Criteria) this;
        }

        public Criteria andApprovalidIsNotNull() {
            addCriterion("approvalid is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalidEqualTo(Integer value) {
            addCriterion("approvalid =", value, "approvalid");
            return (Criteria) this;
        }

        public Criteria andApprovalidNotEqualTo(Integer value) {
            addCriterion("approvalid <>", value, "approvalid");
            return (Criteria) this;
        }

        public Criteria andApprovalidGreaterThan(Integer value) {
            addCriterion("approvalid >", value, "approvalid");
            return (Criteria) this;
        }

        public Criteria andApprovalidGreaterThanOrEqualTo(Integer value) {
            addCriterion("approvalid >=", value, "approvalid");
            return (Criteria) this;
        }

        public Criteria andApprovalidLessThan(Integer value) {
            addCriterion("approvalid <", value, "approvalid");
            return (Criteria) this;
        }

        public Criteria andApprovalidLessThanOrEqualTo(Integer value) {
            addCriterion("approvalid <=", value, "approvalid");
            return (Criteria) this;
        }

        public Criteria andApprovalidIn(List<Integer> values) {
            addCriterion("approvalid in", values, "approvalid");
            return (Criteria) this;
        }

        public Criteria andApprovalidNotIn(List<Integer> values) {
            addCriterion("approvalid not in", values, "approvalid");
            return (Criteria) this;
        }

        public Criteria andApprovalidBetween(Integer value1, Integer value2) {
            addCriterion("approvalid between", value1, value2, "approvalid");
            return (Criteria) this;
        }

        public Criteria andApprovalidNotBetween(Integer value1, Integer value2) {
            addCriterion("approvalid not between", value1, value2, "approvalid");
            return (Criteria) this;
        }

        public Criteria andReplyidIsNull() {
            addCriterion("replyid is null");
            return (Criteria) this;
        }

        public Criteria andReplyidIsNotNull() {
            addCriterion("replyid is not null");
            return (Criteria) this;
        }

        public Criteria andReplyidEqualTo(Integer value) {
            addCriterion("replyid =", value, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidNotEqualTo(Integer value) {
            addCriterion("replyid <>", value, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidGreaterThan(Integer value) {
            addCriterion("replyid >", value, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("replyid >=", value, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidLessThan(Integer value) {
            addCriterion("replyid <", value, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidLessThanOrEqualTo(Integer value) {
            addCriterion("replyid <=", value, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidIn(List<Integer> values) {
            addCriterion("replyid in", values, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidNotIn(List<Integer> values) {
            addCriterion("replyid not in", values, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidBetween(Integer value1, Integer value2) {
            addCriterion("replyid between", value1, value2, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidNotBetween(Integer value1, Integer value2) {
            addCriterion("replyid not between", value1, value2, "replyid");
            return (Criteria) this;
        }

        public Criteria andMonitoridIsNull() {
            addCriterion("monitorid is null");
            return (Criteria) this;
        }

        public Criteria andMonitoridIsNotNull() {
            addCriterion("monitorid is not null");
            return (Criteria) this;
        }

        public Criteria andMonitoridEqualTo(Integer value) {
            addCriterion("monitorid =", value, "monitorid");
            return (Criteria) this;
        }

        public Criteria andMonitoridNotEqualTo(Integer value) {
            addCriterion("monitorid <>", value, "monitorid");
            return (Criteria) this;
        }

        public Criteria andMonitoridGreaterThan(Integer value) {
            addCriterion("monitorid >", value, "monitorid");
            return (Criteria) this;
        }

        public Criteria andMonitoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("monitorid >=", value, "monitorid");
            return (Criteria) this;
        }

        public Criteria andMonitoridLessThan(Integer value) {
            addCriterion("monitorid <", value, "monitorid");
            return (Criteria) this;
        }

        public Criteria andMonitoridLessThanOrEqualTo(Integer value) {
            addCriterion("monitorid <=", value, "monitorid");
            return (Criteria) this;
        }

        public Criteria andMonitoridIn(List<Integer> values) {
            addCriterion("monitorid in", values, "monitorid");
            return (Criteria) this;
        }

        public Criteria andMonitoridNotIn(List<Integer> values) {
            addCriterion("monitorid not in", values, "monitorid");
            return (Criteria) this;
        }

        public Criteria andMonitoridBetween(Integer value1, Integer value2) {
            addCriterion("monitorid between", value1, value2, "monitorid");
            return (Criteria) this;
        }

        public Criteria andMonitoridNotBetween(Integer value1, Integer value2) {
            addCriterion("monitorid not between", value1, value2, "monitorid");
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
     * This class corresponds to the database table d_period
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
     * This class corresponds to the database table d_period
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