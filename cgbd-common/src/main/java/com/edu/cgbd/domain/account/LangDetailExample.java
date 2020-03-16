package com.edu.cgbd.domain.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LangDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LangDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLangKeyIsNull() {
            addCriterion("lang_key is null");
            return (Criteria) this;
        }

        public Criteria andLangKeyIsNotNull() {
            addCriterion("lang_key is not null");
            return (Criteria) this;
        }

        public Criteria andLangKeyEqualTo(String value) {
            addCriterion("lang_key =", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyNotEqualTo(String value) {
            addCriterion("lang_key <>", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyGreaterThan(String value) {
            addCriterion("lang_key >", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyGreaterThanOrEqualTo(String value) {
            addCriterion("lang_key >=", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyLessThan(String value) {
            addCriterion("lang_key <", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyLessThanOrEqualTo(String value) {
            addCriterion("lang_key <=", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyLike(String value) {
            addCriterion("lang_key like", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyNotLike(String value) {
            addCriterion("lang_key not like", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyIn(List<String> values) {
            addCriterion("lang_key in", values, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyNotIn(List<String> values) {
            addCriterion("lang_key not in", values, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyBetween(String value1, String value2) {
            addCriterion("lang_key between", value1, value2, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyNotBetween(String value1, String value2) {
            addCriterion("lang_key not between", value1, value2, "langKey");
            return (Criteria) this;
        }

        public Criteria andZhTwIsNull() {
            addCriterion("zh_tw is null");
            return (Criteria) this;
        }

        public Criteria andZhTwIsNotNull() {
            addCriterion("zh_tw is not null");
            return (Criteria) this;
        }

        public Criteria andZhTwEqualTo(String value) {
            addCriterion("zh_tw =", value, "zhTw");
            return (Criteria) this;
        }

        public Criteria andZhTwNotEqualTo(String value) {
            addCriterion("zh_tw <>", value, "zhTw");
            return (Criteria) this;
        }

        public Criteria andZhTwGreaterThan(String value) {
            addCriterion("zh_tw >", value, "zhTw");
            return (Criteria) this;
        }

        public Criteria andZhTwGreaterThanOrEqualTo(String value) {
            addCriterion("zh_tw >=", value, "zhTw");
            return (Criteria) this;
        }

        public Criteria andZhTwLessThan(String value) {
            addCriterion("zh_tw <", value, "zhTw");
            return (Criteria) this;
        }

        public Criteria andZhTwLessThanOrEqualTo(String value) {
            addCriterion("zh_tw <=", value, "zhTw");
            return (Criteria) this;
        }

        public Criteria andZhTwLike(String value) {
            addCriterion("zh_tw like", value, "zhTw");
            return (Criteria) this;
        }

        public Criteria andZhTwNotLike(String value) {
            addCriterion("zh_tw not like", value, "zhTw");
            return (Criteria) this;
        }

        public Criteria andZhTwIn(List<String> values) {
            addCriterion("zh_tw in", values, "zhTw");
            return (Criteria) this;
        }

        public Criteria andZhTwNotIn(List<String> values) {
            addCriterion("zh_tw not in", values, "zhTw");
            return (Criteria) this;
        }

        public Criteria andZhTwBetween(String value1, String value2) {
            addCriterion("zh_tw between", value1, value2, "zhTw");
            return (Criteria) this;
        }

        public Criteria andZhTwNotBetween(String value1, String value2) {
            addCriterion("zh_tw not between", value1, value2, "zhTw");
            return (Criteria) this;
        }

        public Criteria andZhCnIsNull() {
            addCriterion("zh_cn is null");
            return (Criteria) this;
        }

        public Criteria andZhCnIsNotNull() {
            addCriterion("zh_cn is not null");
            return (Criteria) this;
        }

        public Criteria andZhCnEqualTo(String value) {
            addCriterion("zh_cn =", value, "zhCn");
            return (Criteria) this;
        }

        public Criteria andZhCnNotEqualTo(String value) {
            addCriterion("zh_cn <>", value, "zhCn");
            return (Criteria) this;
        }

        public Criteria andZhCnGreaterThan(String value) {
            addCriterion("zh_cn >", value, "zhCn");
            return (Criteria) this;
        }

        public Criteria andZhCnGreaterThanOrEqualTo(String value) {
            addCriterion("zh_cn >=", value, "zhCn");
            return (Criteria) this;
        }

        public Criteria andZhCnLessThan(String value) {
            addCriterion("zh_cn <", value, "zhCn");
            return (Criteria) this;
        }

        public Criteria andZhCnLessThanOrEqualTo(String value) {
            addCriterion("zh_cn <=", value, "zhCn");
            return (Criteria) this;
        }

        public Criteria andZhCnLike(String value) {
            addCriterion("zh_cn like", value, "zhCn");
            return (Criteria) this;
        }

        public Criteria andZhCnNotLike(String value) {
            addCriterion("zh_cn not like", value, "zhCn");
            return (Criteria) this;
        }

        public Criteria andZhCnIn(List<String> values) {
            addCriterion("zh_cn in", values, "zhCn");
            return (Criteria) this;
        }

        public Criteria andZhCnNotIn(List<String> values) {
            addCriterion("zh_cn not in", values, "zhCn");
            return (Criteria) this;
        }

        public Criteria andZhCnBetween(String value1, String value2) {
            addCriterion("zh_cn between", value1, value2, "zhCn");
            return (Criteria) this;
        }

        public Criteria andZhCnNotBetween(String value1, String value2) {
            addCriterion("zh_cn not between", value1, value2, "zhCn");
            return (Criteria) this;
        }

        public Criteria andEnIsNull() {
            addCriterion("en is null");
            return (Criteria) this;
        }

        public Criteria andEnIsNotNull() {
            addCriterion("en is not null");
            return (Criteria) this;
        }

        public Criteria andEnEqualTo(String value) {
            addCriterion("en =", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnNotEqualTo(String value) {
            addCriterion("en <>", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnGreaterThan(String value) {
            addCriterion("en >", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnGreaterThanOrEqualTo(String value) {
            addCriterion("en >=", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnLessThan(String value) {
            addCriterion("en <", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnLessThanOrEqualTo(String value) {
            addCriterion("en <=", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnLike(String value) {
            addCriterion("en like", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnNotLike(String value) {
            addCriterion("en not like", value, "en");
            return (Criteria) this;
        }

        public Criteria andEnIn(List<String> values) {
            addCriterion("en in", values, "en");
            return (Criteria) this;
        }

        public Criteria andEnNotIn(List<String> values) {
            addCriterion("en not in", values, "en");
            return (Criteria) this;
        }

        public Criteria andEnBetween(String value1, String value2) {
            addCriterion("en between", value1, value2, "en");
            return (Criteria) this;
        }

        public Criteria andEnNotBetween(String value1, String value2) {
            addCriterion("en not between", value1, value2, "en");
            return (Criteria) this;
        }

        public Criteria andJpIsNull() {
            addCriterion("jp is null");
            return (Criteria) this;
        }

        public Criteria andJpIsNotNull() {
            addCriterion("jp is not null");
            return (Criteria) this;
        }

        public Criteria andJpEqualTo(String value) {
            addCriterion("jp =", value, "jp");
            return (Criteria) this;
        }

        public Criteria andJpNotEqualTo(String value) {
            addCriterion("jp <>", value, "jp");
            return (Criteria) this;
        }

        public Criteria andJpGreaterThan(String value) {
            addCriterion("jp >", value, "jp");
            return (Criteria) this;
        }

        public Criteria andJpGreaterThanOrEqualTo(String value) {
            addCriterion("jp >=", value, "jp");
            return (Criteria) this;
        }

        public Criteria andJpLessThan(String value) {
            addCriterion("jp <", value, "jp");
            return (Criteria) this;
        }

        public Criteria andJpLessThanOrEqualTo(String value) {
            addCriterion("jp <=", value, "jp");
            return (Criteria) this;
        }

        public Criteria andJpLike(String value) {
            addCriterion("jp like", value, "jp");
            return (Criteria) this;
        }

        public Criteria andJpNotLike(String value) {
            addCriterion("jp not like", value, "jp");
            return (Criteria) this;
        }

        public Criteria andJpIn(List<String> values) {
            addCriterion("jp in", values, "jp");
            return (Criteria) this;
        }

        public Criteria andJpNotIn(List<String> values) {
            addCriterion("jp not in", values, "jp");
            return (Criteria) this;
        }

        public Criteria andJpBetween(String value1, String value2) {
            addCriterion("jp between", value1, value2, "jp");
            return (Criteria) this;
        }

        public Criteria andJpNotBetween(String value1, String value2) {
            addCriterion("jp not between", value1, value2, "jp");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Long value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Long value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Long value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Long value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Long value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Long> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Long> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Long value1, Long value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Long value1, Long value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateOnIsNull() {
            addCriterion("update_on is null");
            return (Criteria) this;
        }

        public Criteria andUpdateOnIsNotNull() {
            addCriterion("update_on is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateOnEqualTo(Date value) {
            addCriterion("update_on =", value, "updateOn");
            return (Criteria) this;
        }

        public Criteria andUpdateOnNotEqualTo(Date value) {
            addCriterion("update_on <>", value, "updateOn");
            return (Criteria) this;
        }

        public Criteria andUpdateOnGreaterThan(Date value) {
            addCriterion("update_on >", value, "updateOn");
            return (Criteria) this;
        }

        public Criteria andUpdateOnGreaterThanOrEqualTo(Date value) {
            addCriterion("update_on >=", value, "updateOn");
            return (Criteria) this;
        }

        public Criteria andUpdateOnLessThan(Date value) {
            addCriterion("update_on <", value, "updateOn");
            return (Criteria) this;
        }

        public Criteria andUpdateOnLessThanOrEqualTo(Date value) {
            addCriterion("update_on <=", value, "updateOn");
            return (Criteria) this;
        }

        public Criteria andUpdateOnIn(List<Date> values) {
            addCriterion("update_on in", values, "updateOn");
            return (Criteria) this;
        }

        public Criteria andUpdateOnNotIn(List<Date> values) {
            addCriterion("update_on not in", values, "updateOn");
            return (Criteria) this;
        }

        public Criteria andUpdateOnBetween(Date value1, Date value2) {
            addCriterion("update_on between", value1, value2, "updateOn");
            return (Criteria) this;
        }

        public Criteria andUpdateOnNotBetween(Date value1, Date value2) {
            addCriterion("update_on not between", value1, value2, "updateOn");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNull() {
            addCriterion("reserve1 is null");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNotNull() {
            addCriterion("reserve1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve1EqualTo(String value) {
            addCriterion("reserve1 =", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotEqualTo(String value) {
            addCriterion("reserve1 <>", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThan(String value) {
            addCriterion("reserve1 >", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThanOrEqualTo(String value) {
            addCriterion("reserve1 >=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThan(String value) {
            addCriterion("reserve1 <", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThanOrEqualTo(String value) {
            addCriterion("reserve1 <=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Like(String value) {
            addCriterion("reserve1 like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotLike(String value) {
            addCriterion("reserve1 not like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1In(List<String> values) {
            addCriterion("reserve1 in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotIn(List<String> values) {
            addCriterion("reserve1 not in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Between(String value1, String value2) {
            addCriterion("reserve1 between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotBetween(String value1, String value2) {
            addCriterion("reserve1 not between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNull() {
            addCriterion("reserve2 is null");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNotNull() {
            addCriterion("reserve2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve2EqualTo(String value) {
            addCriterion("reserve2 =", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotEqualTo(String value) {
            addCriterion("reserve2 <>", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThan(String value) {
            addCriterion("reserve2 >", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThanOrEqualTo(String value) {
            addCriterion("reserve2 >=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThan(String value) {
            addCriterion("reserve2 <", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThanOrEqualTo(String value) {
            addCriterion("reserve2 <=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Like(String value) {
            addCriterion("reserve2 like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotLike(String value) {
            addCriterion("reserve2 not like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2In(List<String> values) {
            addCriterion("reserve2 in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotIn(List<String> values) {
            addCriterion("reserve2 not in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Between(String value1, String value2) {
            addCriterion("reserve2 between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotBetween(String value1, String value2) {
            addCriterion("reserve2 not between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNull() {
            addCriterion("reserve3 is null");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNotNull() {
            addCriterion("reserve3 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve3EqualTo(String value) {
            addCriterion("reserve3 =", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotEqualTo(String value) {
            addCriterion("reserve3 <>", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThan(String value) {
            addCriterion("reserve3 >", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThanOrEqualTo(String value) {
            addCriterion("reserve3 >=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThan(String value) {
            addCriterion("reserve3 <", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThanOrEqualTo(String value) {
            addCriterion("reserve3 <=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Like(String value) {
            addCriterion("reserve3 like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotLike(String value) {
            addCriterion("reserve3 not like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3In(List<String> values) {
            addCriterion("reserve3 in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotIn(List<String> values) {
            addCriterion("reserve3 not in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Between(String value1, String value2) {
            addCriterion("reserve3 between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotBetween(String value1, String value2) {
            addCriterion("reserve3 not between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve4IsNull() {
            addCriterion("reserve4 is null");
            return (Criteria) this;
        }

        public Criteria andReserve4IsNotNull() {
            addCriterion("reserve4 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve4EqualTo(String value) {
            addCriterion("reserve4 =", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotEqualTo(String value) {
            addCriterion("reserve4 <>", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4GreaterThan(String value) {
            addCriterion("reserve4 >", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4GreaterThanOrEqualTo(String value) {
            addCriterion("reserve4 >=", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4LessThan(String value) {
            addCriterion("reserve4 <", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4LessThanOrEqualTo(String value) {
            addCriterion("reserve4 <=", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4Like(String value) {
            addCriterion("reserve4 like", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotLike(String value) {
            addCriterion("reserve4 not like", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4In(List<String> values) {
            addCriterion("reserve4 in", values, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotIn(List<String> values) {
            addCriterion("reserve4 not in", values, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4Between(String value1, String value2) {
            addCriterion("reserve4 between", value1, value2, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotBetween(String value1, String value2) {
            addCriterion("reserve4 not between", value1, value2, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve5IsNull() {
            addCriterion("reserve5 is null");
            return (Criteria) this;
        }

        public Criteria andReserve5IsNotNull() {
            addCriterion("reserve5 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve5EqualTo(String value) {
            addCriterion("reserve5 =", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotEqualTo(String value) {
            addCriterion("reserve5 <>", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5GreaterThan(String value) {
            addCriterion("reserve5 >", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5GreaterThanOrEqualTo(String value) {
            addCriterion("reserve5 >=", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5LessThan(String value) {
            addCriterion("reserve5 <", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5LessThanOrEqualTo(String value) {
            addCriterion("reserve5 <=", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5Like(String value) {
            addCriterion("reserve5 like", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotLike(String value) {
            addCriterion("reserve5 not like", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5In(List<String> values) {
            addCriterion("reserve5 in", values, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotIn(List<String> values) {
            addCriterion("reserve5 not in", values, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5Between(String value1, String value2) {
            addCriterion("reserve5 between", value1, value2, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotBetween(String value1, String value2) {
            addCriterion("reserve5 not between", value1, value2, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve6IsNull() {
            addCriterion("reserve6 is null");
            return (Criteria) this;
        }

        public Criteria andReserve6IsNotNull() {
            addCriterion("reserve6 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve6EqualTo(String value) {
            addCriterion("reserve6 =", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6NotEqualTo(String value) {
            addCriterion("reserve6 <>", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6GreaterThan(String value) {
            addCriterion("reserve6 >", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6GreaterThanOrEqualTo(String value) {
            addCriterion("reserve6 >=", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6LessThan(String value) {
            addCriterion("reserve6 <", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6LessThanOrEqualTo(String value) {
            addCriterion("reserve6 <=", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6Like(String value) {
            addCriterion("reserve6 like", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6NotLike(String value) {
            addCriterion("reserve6 not like", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6In(List<String> values) {
            addCriterion("reserve6 in", values, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6NotIn(List<String> values) {
            addCriterion("reserve6 not in", values, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6Between(String value1, String value2) {
            addCriterion("reserve6 between", value1, value2, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6NotBetween(String value1, String value2) {
            addCriterion("reserve6 not between", value1, value2, "reserve6");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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