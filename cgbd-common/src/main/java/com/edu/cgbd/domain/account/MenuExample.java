package com.edu.cgbd.domain.account;

import java.util.ArrayList;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuExample() {
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

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuRouteIsNull() {
            addCriterion("menu_route is null");
            return (Criteria) this;
        }

        public Criteria andMenuRouteIsNotNull() {
            addCriterion("menu_route is not null");
            return (Criteria) this;
        }

        public Criteria andMenuRouteEqualTo(String value) {
            addCriterion("menu_route =", value, "menuRoute");
            return (Criteria) this;
        }

        public Criteria andMenuRouteNotEqualTo(String value) {
            addCriterion("menu_route <>", value, "menuRoute");
            return (Criteria) this;
        }

        public Criteria andMenuRouteGreaterThan(String value) {
            addCriterion("menu_route >", value, "menuRoute");
            return (Criteria) this;
        }

        public Criteria andMenuRouteGreaterThanOrEqualTo(String value) {
            addCriterion("menu_route >=", value, "menuRoute");
            return (Criteria) this;
        }

        public Criteria andMenuRouteLessThan(String value) {
            addCriterion("menu_route <", value, "menuRoute");
            return (Criteria) this;
        }

        public Criteria andMenuRouteLessThanOrEqualTo(String value) {
            addCriterion("menu_route <=", value, "menuRoute");
            return (Criteria) this;
        }

        public Criteria andMenuRouteLike(String value) {
            addCriterion("menu_route like", value, "menuRoute");
            return (Criteria) this;
        }

        public Criteria andMenuRouteNotLike(String value) {
            addCriterion("menu_route not like", value, "menuRoute");
            return (Criteria) this;
        }

        public Criteria andMenuRouteIn(List<String> values) {
            addCriterion("menu_route in", values, "menuRoute");
            return (Criteria) this;
        }

        public Criteria andMenuRouteNotIn(List<String> values) {
            addCriterion("menu_route not in", values, "menuRoute");
            return (Criteria) this;
        }

        public Criteria andMenuRouteBetween(String value1, String value2) {
            addCriterion("menu_route between", value1, value2, "menuRoute");
            return (Criteria) this;
        }

        public Criteria andMenuRouteNotBetween(String value1, String value2) {
            addCriterion("menu_route not between", value1, value2, "menuRoute");
            return (Criteria) this;
        }

        public Criteria andMenuActionIsNull() {
            addCriterion("menu_action is null");
            return (Criteria) this;
        }

        public Criteria andMenuActionIsNotNull() {
            addCriterion("menu_action is not null");
            return (Criteria) this;
        }

        public Criteria andMenuActionEqualTo(String value) {
            addCriterion("menu_action =", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionNotEqualTo(String value) {
            addCriterion("menu_action <>", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionGreaterThan(String value) {
            addCriterion("menu_action >", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionGreaterThanOrEqualTo(String value) {
            addCriterion("menu_action >=", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionLessThan(String value) {
            addCriterion("menu_action <", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionLessThanOrEqualTo(String value) {
            addCriterion("menu_action <=", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionLike(String value) {
            addCriterion("menu_action like", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionNotLike(String value) {
            addCriterion("menu_action not like", value, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionIn(List<String> values) {
            addCriterion("menu_action in", values, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionNotIn(List<String> values) {
            addCriterion("menu_action not in", values, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionBetween(String value1, String value2) {
            addCriterion("menu_action between", value1, value2, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuActionNotBetween(String value1, String value2) {
            addCriterion("menu_action not between", value1, value2, "menuAction");
            return (Criteria) this;
        }

        public Criteria andMenuIconIsNull() {
            addCriterion("menu_icon is null");
            return (Criteria) this;
        }

        public Criteria andMenuIconIsNotNull() {
            addCriterion("menu_icon is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIconEqualTo(String value) {
            addCriterion("menu_icon =", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotEqualTo(String value) {
            addCriterion("menu_icon <>", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconGreaterThan(String value) {
            addCriterion("menu_icon >", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconGreaterThanOrEqualTo(String value) {
            addCriterion("menu_icon >=", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLessThan(String value) {
            addCriterion("menu_icon <", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLessThanOrEqualTo(String value) {
            addCriterion("menu_icon <=", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLike(String value) {
            addCriterion("menu_icon like", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotLike(String value) {
            addCriterion("menu_icon not like", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconIn(List<String> values) {
            addCriterion("menu_icon in", values, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotIn(List<String> values) {
            addCriterion("menu_icon not in", values, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconBetween(String value1, String value2) {
            addCriterion("menu_icon between", value1, value2, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotBetween(String value1, String value2) {
            addCriterion("menu_icon not between", value1, value2, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuSortCodeIsNull() {
            addCriterion("menu_sort_code is null");
            return (Criteria) this;
        }

        public Criteria andMenuSortCodeIsNotNull() {
            addCriterion("menu_sort_code is not null");
            return (Criteria) this;
        }

        public Criteria andMenuSortCodeEqualTo(Long value) {
            addCriterion("menu_sort_code =", value, "menuSortCode");
            return (Criteria) this;
        }

        public Criteria andMenuSortCodeNotEqualTo(Long value) {
            addCriterion("menu_sort_code <>", value, "menuSortCode");
            return (Criteria) this;
        }

        public Criteria andMenuSortCodeGreaterThan(Long value) {
            addCriterion("menu_sort_code >", value, "menuSortCode");
            return (Criteria) this;
        }

        public Criteria andMenuSortCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("menu_sort_code >=", value, "menuSortCode");
            return (Criteria) this;
        }

        public Criteria andMenuSortCodeLessThan(Long value) {
            addCriterion("menu_sort_code <", value, "menuSortCode");
            return (Criteria) this;
        }

        public Criteria andMenuSortCodeLessThanOrEqualTo(Long value) {
            addCriterion("menu_sort_code <=", value, "menuSortCode");
            return (Criteria) this;
        }

        public Criteria andMenuSortCodeIn(List<Long> values) {
            addCriterion("menu_sort_code in", values, "menuSortCode");
            return (Criteria) this;
        }

        public Criteria andMenuSortCodeNotIn(List<Long> values) {
            addCriterion("menu_sort_code not in", values, "menuSortCode");
            return (Criteria) this;
        }

        public Criteria andMenuSortCodeBetween(Long value1, Long value2) {
            addCriterion("menu_sort_code between", value1, value2, "menuSortCode");
            return (Criteria) this;
        }

        public Criteria andMenuSortCodeNotBetween(Long value1, Long value2) {
            addCriterion("menu_sort_code not between", value1, value2, "menuSortCode");
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