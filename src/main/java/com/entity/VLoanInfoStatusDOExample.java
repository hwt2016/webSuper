package com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VLoanInfoStatusDOExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    protected Integer limitStart;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    protected Integer limitEnd;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    public VLoanInfoStatusDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_loaninfo_status
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
     * This method corresponds to the database table v_user_loaninfo_status
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
     * This method corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_loaninfo_status
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
     * This method corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_user_loaninfo_status
     *
     * @mbggenerated
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table v_user_loaninfo_status
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

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andLoanmountIsNull() {
            addCriterion("loanmount is null");
            return (Criteria) this;
        }

        public Criteria andLoanmountIsNotNull() {
            addCriterion("loanmount is not null");
            return (Criteria) this;
        }

        public Criteria andLoanmountEqualTo(Integer value) {
            addCriterion("loanmount =", value, "loanmount");
            return (Criteria) this;
        }

        public Criteria andLoanmountNotEqualTo(Integer value) {
            addCriterion("loanmount <>", value, "loanmount");
            return (Criteria) this;
        }

        public Criteria andLoanmountGreaterThan(Integer value) {
            addCriterion("loanmount >", value, "loanmount");
            return (Criteria) this;
        }

        public Criteria andLoanmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("loanmount >=", value, "loanmount");
            return (Criteria) this;
        }

        public Criteria andLoanmountLessThan(Integer value) {
            addCriterion("loanmount <", value, "loanmount");
            return (Criteria) this;
        }

        public Criteria andLoanmountLessThanOrEqualTo(Integer value) {
            addCriterion("loanmount <=", value, "loanmount");
            return (Criteria) this;
        }

        public Criteria andLoanmountIn(List<Integer> values) {
            addCriterion("loanmount in", values, "loanmount");
            return (Criteria) this;
        }

        public Criteria andLoanmountNotIn(List<Integer> values) {
            addCriterion("loanmount not in", values, "loanmount");
            return (Criteria) this;
        }

        public Criteria andLoanmountBetween(Integer value1, Integer value2) {
            addCriterion("loanmount between", value1, value2, "loanmount");
            return (Criteria) this;
        }

        public Criteria andLoanmountNotBetween(Integer value1, Integer value2) {
            addCriterion("loanmount not between", value1, value2, "loanmount");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idCard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idCard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idCard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idCard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idCard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idCard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idCard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idCard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idCard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idCard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idCard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idCard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idCard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idCard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusIsNull() {
            addCriterion("acceptstatus is null");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusIsNotNull() {
            addCriterion("acceptstatus is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusEqualTo(String value) {
            addCriterion("acceptstatus =", value, "acceptstatus");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusNotEqualTo(String value) {
            addCriterion("acceptstatus <>", value, "acceptstatus");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusGreaterThan(String value) {
            addCriterion("acceptstatus >", value, "acceptstatus");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusGreaterThanOrEqualTo(String value) {
            addCriterion("acceptstatus >=", value, "acceptstatus");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusLessThan(String value) {
            addCriterion("acceptstatus <", value, "acceptstatus");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusLessThanOrEqualTo(String value) {
            addCriterion("acceptstatus <=", value, "acceptstatus");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusLike(String value) {
            addCriterion("acceptstatus like", value, "acceptstatus");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusNotLike(String value) {
            addCriterion("acceptstatus not like", value, "acceptstatus");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusIn(List<String> values) {
            addCriterion("acceptstatus in", values, "acceptstatus");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusNotIn(List<String> values) {
            addCriterion("acceptstatus not in", values, "acceptstatus");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusBetween(String value1, String value2) {
            addCriterion("acceptstatus between", value1, value2, "acceptstatus");
            return (Criteria) this;
        }

        public Criteria andAcceptstatusNotBetween(String value1, String value2) {
            addCriterion("acceptstatus not between", value1, value2, "acceptstatus");
            return (Criteria) this;
        }

        public Criteria andAccepttimeIsNull() {
            addCriterion("accepttime is null");
            return (Criteria) this;
        }

        public Criteria andAccepttimeIsNotNull() {
            addCriterion("accepttime is not null");
            return (Criteria) this;
        }

        public Criteria andAccepttimeEqualTo(Date value) {
            addCriterion("accepttime =", value, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeNotEqualTo(Date value) {
            addCriterion("accepttime <>", value, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeGreaterThan(Date value) {
            addCriterion("accepttime >", value, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("accepttime >=", value, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeLessThan(Date value) {
            addCriterion("accepttime <", value, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeLessThanOrEqualTo(Date value) {
            addCriterion("accepttime <=", value, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeIn(List<Date> values) {
            addCriterion("accepttime in", values, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeNotIn(List<Date> values) {
            addCriterion("accepttime not in", values, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeBetween(Date value1, Date value2) {
            addCriterion("accepttime between", value1, value2, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeNotBetween(Date value1, Date value2) {
            addCriterion("accepttime not between", value1, value2, "accepttime");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusIsNull() {
            addCriterion("approvalstatus is null");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusIsNotNull() {
            addCriterion("approvalstatus is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusEqualTo(String value) {
            addCriterion("approvalstatus =", value, "approvalstatus");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusNotEqualTo(String value) {
            addCriterion("approvalstatus <>", value, "approvalstatus");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusGreaterThan(String value) {
            addCriterion("approvalstatus >", value, "approvalstatus");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusGreaterThanOrEqualTo(String value) {
            addCriterion("approvalstatus >=", value, "approvalstatus");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusLessThan(String value) {
            addCriterion("approvalstatus <", value, "approvalstatus");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusLessThanOrEqualTo(String value) {
            addCriterion("approvalstatus <=", value, "approvalstatus");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusLike(String value) {
            addCriterion("approvalstatus like", value, "approvalstatus");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusNotLike(String value) {
            addCriterion("approvalstatus not like", value, "approvalstatus");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusIn(List<String> values) {
            addCriterion("approvalstatus in", values, "approvalstatus");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusNotIn(List<String> values) {
            addCriterion("approvalstatus not in", values, "approvalstatus");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusBetween(String value1, String value2) {
            addCriterion("approvalstatus between", value1, value2, "approvalstatus");
            return (Criteria) this;
        }

        public Criteria andApprovalstatusNotBetween(String value1, String value2) {
            addCriterion("approvalstatus not between", value1, value2, "approvalstatus");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeIsNull() {
            addCriterion("approvaltime is null");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeIsNotNull() {
            addCriterion("approvaltime is not null");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeEqualTo(Date value) {
            addCriterion("approvaltime =", value, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeNotEqualTo(Date value) {
            addCriterion("approvaltime <>", value, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeGreaterThan(Date value) {
            addCriterion("approvaltime >", value, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approvaltime >=", value, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeLessThan(Date value) {
            addCriterion("approvaltime <", value, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeLessThanOrEqualTo(Date value) {
            addCriterion("approvaltime <=", value, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeIn(List<Date> values) {
            addCriterion("approvaltime in", values, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeNotIn(List<Date> values) {
            addCriterion("approvaltime not in", values, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeBetween(Date value1, Date value2) {
            addCriterion("approvaltime between", value1, value2, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andApprovaltimeNotBetween(Date value1, Date value2) {
            addCriterion("approvaltime not between", value1, value2, "approvaltime");
            return (Criteria) this;
        }

        public Criteria andReplystatusIsNull() {
            addCriterion("replystatus is null");
            return (Criteria) this;
        }

        public Criteria andReplystatusIsNotNull() {
            addCriterion("replystatus is not null");
            return (Criteria) this;
        }

        public Criteria andReplystatusEqualTo(String value) {
            addCriterion("replystatus =", value, "replystatus");
            return (Criteria) this;
        }

        public Criteria andReplystatusNotEqualTo(String value) {
            addCriterion("replystatus <>", value, "replystatus");
            return (Criteria) this;
        }

        public Criteria andReplystatusGreaterThan(String value) {
            addCriterion("replystatus >", value, "replystatus");
            return (Criteria) this;
        }

        public Criteria andReplystatusGreaterThanOrEqualTo(String value) {
            addCriterion("replystatus >=", value, "replystatus");
            return (Criteria) this;
        }

        public Criteria andReplystatusLessThan(String value) {
            addCriterion("replystatus <", value, "replystatus");
            return (Criteria) this;
        }

        public Criteria andReplystatusLessThanOrEqualTo(String value) {
            addCriterion("replystatus <=", value, "replystatus");
            return (Criteria) this;
        }

        public Criteria andReplystatusLike(String value) {
            addCriterion("replystatus like", value, "replystatus");
            return (Criteria) this;
        }

        public Criteria andReplystatusNotLike(String value) {
            addCriterion("replystatus not like", value, "replystatus");
            return (Criteria) this;
        }

        public Criteria andReplystatusIn(List<String> values) {
            addCriterion("replystatus in", values, "replystatus");
            return (Criteria) this;
        }

        public Criteria andReplystatusNotIn(List<String> values) {
            addCriterion("replystatus not in", values, "replystatus");
            return (Criteria) this;
        }

        public Criteria andReplystatusBetween(String value1, String value2) {
            addCriterion("replystatus between", value1, value2, "replystatus");
            return (Criteria) this;
        }

        public Criteria andReplystatusNotBetween(String value1, String value2) {
            addCriterion("replystatus not between", value1, value2, "replystatus");
            return (Criteria) this;
        }

        public Criteria andReplytimeIsNull() {
            addCriterion("replytime is null");
            return (Criteria) this;
        }

        public Criteria andReplytimeIsNotNull() {
            addCriterion("replytime is not null");
            return (Criteria) this;
        }

        public Criteria andReplytimeEqualTo(Date value) {
            addCriterion("replytime =", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeNotEqualTo(Date value) {
            addCriterion("replytime <>", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeGreaterThan(Date value) {
            addCriterion("replytime >", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("replytime >=", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeLessThan(Date value) {
            addCriterion("replytime <", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeLessThanOrEqualTo(Date value) {
            addCriterion("replytime <=", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeIn(List<Date> values) {
            addCriterion("replytime in", values, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeNotIn(List<Date> values) {
            addCriterion("replytime not in", values, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeBetween(Date value1, Date value2) {
            addCriterion("replytime between", value1, value2, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeNotBetween(Date value1, Date value2) {
            addCriterion("replytime not between", value1, value2, "replytime");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusIsNull() {
            addCriterion("monitorstatus is null");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusIsNotNull() {
            addCriterion("monitorstatus is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusEqualTo(String value) {
            addCriterion("monitorstatus =", value, "monitorstatus");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusNotEqualTo(String value) {
            addCriterion("monitorstatus <>", value, "monitorstatus");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusGreaterThan(String value) {
            addCriterion("monitorstatus >", value, "monitorstatus");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusGreaterThanOrEqualTo(String value) {
            addCriterion("monitorstatus >=", value, "monitorstatus");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusLessThan(String value) {
            addCriterion("monitorstatus <", value, "monitorstatus");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusLessThanOrEqualTo(String value) {
            addCriterion("monitorstatus <=", value, "monitorstatus");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusLike(String value) {
            addCriterion("monitorstatus like", value, "monitorstatus");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusNotLike(String value) {
            addCriterion("monitorstatus not like", value, "monitorstatus");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusIn(List<String> values) {
            addCriterion("monitorstatus in", values, "monitorstatus");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusNotIn(List<String> values) {
            addCriterion("monitorstatus not in", values, "monitorstatus");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusBetween(String value1, String value2) {
            addCriterion("monitorstatus between", value1, value2, "monitorstatus");
            return (Criteria) this;
        }

        public Criteria andMonitorstatusNotBetween(String value1, String value2) {
            addCriterion("monitorstatus not between", value1, value2, "monitorstatus");
            return (Criteria) this;
        }

        public Criteria andMonitortimeIsNull() {
            addCriterion("monitortime is null");
            return (Criteria) this;
        }

        public Criteria andMonitortimeIsNotNull() {
            addCriterion("monitortime is not null");
            return (Criteria) this;
        }

        public Criteria andMonitortimeEqualTo(Date value) {
            addCriterion("monitortime =", value, "monitortime");
            return (Criteria) this;
        }

        public Criteria andMonitortimeNotEqualTo(Date value) {
            addCriterion("monitortime <>", value, "monitortime");
            return (Criteria) this;
        }

        public Criteria andMonitortimeGreaterThan(Date value) {
            addCriterion("monitortime >", value, "monitortime");
            return (Criteria) this;
        }

        public Criteria andMonitortimeGreaterThanOrEqualTo(Date value) {
            addCriterion("monitortime >=", value, "monitortime");
            return (Criteria) this;
        }

        public Criteria andMonitortimeLessThan(Date value) {
            addCriterion("monitortime <", value, "monitortime");
            return (Criteria) this;
        }

        public Criteria andMonitortimeLessThanOrEqualTo(Date value) {
            addCriterion("monitortime <=", value, "monitortime");
            return (Criteria) this;
        }

        public Criteria andMonitortimeIn(List<Date> values) {
            addCriterion("monitortime in", values, "monitortime");
            return (Criteria) this;
        }

        public Criteria andMonitortimeNotIn(List<Date> values) {
            addCriterion("monitortime not in", values, "monitortime");
            return (Criteria) this;
        }

        public Criteria andMonitortimeBetween(Date value1, Date value2) {
            addCriterion("monitortime between", value1, value2, "monitortime");
            return (Criteria) this;
        }

        public Criteria andMonitortimeNotBetween(Date value1, Date value2) {
            addCriterion("monitortime not between", value1, value2, "monitortime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table v_user_loaninfo_status
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
     * This class corresponds to the database table v_user_loaninfo_status
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