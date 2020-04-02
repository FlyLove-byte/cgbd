package com.edu.cgbd.domain.account;

import java.util.ArrayList;
import java.util.List;

public class MenuGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuGroupExample() {
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

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupRouteIsNull() {
            addCriterion("group_route is null");
            return (Criteria) this;
        }

        public Criteria andGroupRouteIsNotNull() {
            addCriterion("group_route is not null");
            return (Criteria) this;
        }

        public Criteria andGroupRouteEqualTo(String value) {
            addCriterion("group_route =", value, "groupRoute");
            return (Criteria) this;
        }

        public Criteria andGroupRouteNotEqualTo(String value) {
            addCriterion("group_route <>", value, "groupRoute");
            return (Criteria) this;
        }

        public Criteria andGroupRouteGreaterThan(String value) {
            addCriterion("group_route >", value, "groupRoute");
            return (Criteria) this;
        }

        public Criteria andGroupRouteGreaterThanOrEqualTo(String value) {
            addCriterion("group_route >=", value, "groupRoute");
            return (Criteria) this;
        }

        public Criteria andGroupRouteLessThan(String value) {
            addCriterion("group_route <", value, "groupRoute");
            return (Criteria) this;
        }

        public Criteria andGroupRouteLessThanOrEqualTo(String value) {
            addCriterion("group_route <=", value, "groupRoute");
            return (Criteria) this;
        }

        public Criteria andGroupRouteLike(String value) {
            addCriterion("group_route like", value, "groupRoute");
            return (Criteria) this;
        }

        public Criteria andGroupRouteNotLike(String value) {
            addCriterion("group_route not like", value, "groupRoute");
            return (Criteria) this;
        }

        public Criteria andGroupRouteIn(List<String> values) {
            addCriterion("group_route in", values, "groupRoute");
            return (Criteria) this;
        }

        public Criteria andGroupRouteNotIn(List<String> values) {
            addCriterion("group_route not in", values, "groupRoute");
            return (Criteria) this;
        }

        public Criteria andGroupRouteBetween(String value1, String value2) {
            addCriterion("group_route between", value1, value2, "groupRoute");
            return (Criteria) this;
        }

        public Criteria andGroupRouteNotBetween(String value1, String value2) {
            addCriterion("group_route not between", value1, value2, "groupRoute");
            return (Criteria) this;
        }

        public Criteria andGroupActionIsNull() {
            addCriterion("group_action is null");
            return (Criteria) this;
        }

        public Criteria andGroupActionIsNotNull() {
            addCriterion("group_action is not null");
            return (Criteria) this;
        }

        public Criteria andGroupActionEqualTo(String value) {
            addCriterion("group_action =", value, "groupAction");
            return (Criteria) this;
        }

        public Criteria andGroupActionNotEqualTo(String value) {
            addCriterion("group_action <>", value, "groupAction");
            return (Criteria) this;
        }

        public Criteria andGroupActionGreaterThan(String value) {
            addCriterion("group_action >", value, "groupAction");
            return (Criteria) this;
        }

        public Criteria andGroupActionGreaterThanOrEqualTo(String value) {
            addCriterion("group_action >=", value, "groupAction");
            return (Criteria) this;
        }

        public Criteria andGroupActionLessThan(String value) {
            addCriterion("group_action <", value, "groupAction");
            return (Criteria) this;
        }

        public Criteria andGroupActionLessThanOrEqualTo(String value) {
            addCriterion("group_action <=", value, "groupAction");
            return (Criteria) this;
        }

        public Criteria andGroupActionLike(String value) {
            addCriterion("group_action like", value, "groupAction");
            return (Criteria) this;
        }

        public Criteria andGroupActionNotLike(String value) {
            addCriterion("group_action not like", value, "groupAction");
            return (Criteria) this;
        }

        public Criteria andGroupActionIn(List<String> values) {
            addCriterion("group_action in", values, "groupAction");
            return (Criteria) this;
        }

        public Criteria andGroupActionNotIn(List<String> values) {
            addCriterion("group_action not in", values, "groupAction");
            return (Criteria) this;
        }

        public Criteria andGroupActionBetween(String value1, String value2) {
            addCriterion("group_action between", value1, value2, "groupAction");
            return (Criteria) this;
        }

        public Criteria andGroupActionNotBetween(String value1, String value2) {
            addCriterion("group_action not between", value1, value2, "groupAction");
            return (Criteria) this;
        }

        public Criteria andGroupIconIsNull() {
            addCriterion("group_icon is null");
            return (Criteria) this;
        }

        public Criteria andGroupIconIsNotNull() {
            addCriterion("group_icon is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIconEqualTo(String value) {
            addCriterion("group_icon =", value, "groupIcon");
            return (Criteria) this;
        }

        public Criteria andGroupIconNotEqualTo(String value) {
            addCriterion("group_icon <>", value, "groupIcon");
            return (Criteria) this;
        }

        public Criteria andGroupIconGreaterThan(String value) {
            addCriterion("group_icon >", value, "groupIcon");
            return (Criteria) this;
        }

        public Criteria andGroupIconGreaterThanOrEqualTo(String value) {
            addCriterion("group_icon >=", value, "groupIcon");
            return (Criteria) this;
        }

        public Criteria andGroupIconLessThan(String value) {
            addCriterion("group_icon <", value, "groupIcon");
            return (Criteria) this;
        }

        public Criteria andGroupIconLessThanOrEqualTo(String value) {
            addCriterion("group_icon <=", value, "groupIcon");
            return (Criteria) this;
        }

        public Criteria andGroupIconLike(String value) {
            addCriterion("group_icon like", value, "groupIcon");
            return (Criteria) this;
        }

        public Criteria andGroupIconNotLike(String value) {
            addCriterion("group_icon not like", value, "groupIcon");
            return (Criteria) this;
        }

        public Criteria andGroupIconIn(List<String> values) {
            addCriterion("group_icon in", values, "groupIcon");
            return (Criteria) this;
        }

        public Criteria andGroupIconNotIn(List<String> values) {
            addCriterion("group_icon not in", values, "groupIcon");
            return (Criteria) this;
        }

        public Criteria andGroupIconBetween(String value1, String value2) {
            addCriterion("group_icon between", value1, value2, "groupIcon");
            return (Criteria) this;
        }

        public Criteria andGroupIconNotBetween(String value1, String value2) {
            addCriterion("group_icon not between", value1, value2, "groupIcon");
            return (Criteria) this;
        }

        public Criteria andGroupGradeIsNull() {
            addCriterion("group_grade is null");
            return (Criteria) this;
        }

        public Criteria andGroupGradeIsNotNull() {
            addCriterion("group_grade is not null");
            return (Criteria) this;
        }

        public Criteria andGroupGradeEqualTo(Long value) {
            addCriterion("group_grade =", value, "groupGrade");
            return (Criteria) this;
        }

        public Criteria andGroupGradeNotEqualTo(Long value) {
            addCriterion("group_grade <>", value, "groupGrade");
            return (Criteria) this;
        }

        public Criteria andGroupGradeGreaterThan(Long value) {
            addCriterion("group_grade >", value, "groupGrade");
            return (Criteria) this;
        }

        public Criteria andGroupGradeGreaterThanOrEqualTo(Long value) {
            addCriterion("group_grade >=", value, "groupGrade");
            return (Criteria) this;
        }

        public Criteria andGroupGradeLessThan(Long value) {
            addCriterion("group_grade <", value, "groupGrade");
            return (Criteria) this;
        }

        public Criteria andGroupGradeLessThanOrEqualTo(Long value) {
            addCriterion("group_grade <=", value, "groupGrade");
            return (Criteria) this;
        }

        public Criteria andGroupGradeIn(List<Long> values) {
            addCriterion("group_grade in", values, "groupGrade");
            return (Criteria) this;
        }

        public Criteria andGroupGradeNotIn(List<Long> values) {
            addCriterion("group_grade not in", values, "groupGrade");
            return (Criteria) this;
        }

        public Criteria andGroupGradeBetween(Long value1, Long value2) {
            addCriterion("group_grade between", value1, value2, "groupGrade");
            return (Criteria) this;
        }

        public Criteria andGroupGradeNotBetween(Long value1, Long value2) {
            addCriterion("group_grade not between", value1, value2, "groupGrade");
            return (Criteria) this;
        }

        public Criteria andGroupSortCodeIsNull() {
            addCriterion("group_sort_code is null");
            return (Criteria) this;
        }

        public Criteria andGroupSortCodeIsNotNull() {
            addCriterion("group_sort_code is not null");
            return (Criteria) this;
        }

        public Criteria andGroupSortCodeEqualTo(Integer value) {
            addCriterion("group_sort_code =", value, "groupSortCode");
            return (Criteria) this;
        }

        public Criteria andGroupSortCodeNotEqualTo(Integer value) {
            addCriterion("group_sort_code <>", value, "groupSortCode");
            return (Criteria) this;
        }

        public Criteria andGroupSortCodeGreaterThan(Integer value) {
            addCriterion("group_sort_code >", value, "groupSortCode");
            return (Criteria) this;
        }

        public Criteria andGroupSortCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_sort_code >=", value, "groupSortCode");
            return (Criteria) this;
        }

        public Criteria andGroupSortCodeLessThan(Integer value) {
            addCriterion("group_sort_code <", value, "groupSortCode");
            return (Criteria) this;
        }

        public Criteria andGroupSortCodeLessThanOrEqualTo(Integer value) {
            addCriterion("group_sort_code <=", value, "groupSortCode");
            return (Criteria) this;
        }

        public Criteria andGroupSortCodeIn(List<Integer> values) {
            addCriterion("group_sort_code in", values, "groupSortCode");
            return (Criteria) this;
        }

        public Criteria andGroupSortCodeNotIn(List<Integer> values) {
            addCriterion("group_sort_code not in", values, "groupSortCode");
            return (Criteria) this;
        }

        public Criteria andGroupSortCodeBetween(Integer value1, Integer value2) {
            addCriterion("group_sort_code between", value1, value2, "groupSortCode");
            return (Criteria) this;
        }

        public Criteria andGroupSortCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("group_sort_code not between", value1, value2, "groupSortCode");
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