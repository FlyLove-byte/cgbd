package com.edu.cgbd.domain.account;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "menu_group")
public class MenuGroup implements Serializable {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 组名称
     */
    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_route")
    private String groupRoute;

    @Column(name = "group_action")
    private String groupAction;

    @Column(name = "group_icon")
    private String groupIcon;

    @Column(name = "group_grade")
    private Long groupGrade;

    @Column(name = "group_sort_code")
    private Integer groupSortCode;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取组名称
     *
     * @return group_name - 组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置组名称
     *
     * @param groupName 组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * @return group_route
     */
    public String getGroupRoute() {
        return groupRoute;
    }

    /**
     * @param groupRoute
     */
    public void setGroupRoute(String groupRoute) {
        this.groupRoute = groupRoute == null ? null : groupRoute.trim();
    }

    /**
     * @return group_action
     */
    public String getGroupAction() {
        return groupAction;
    }

    /**
     * @param groupAction
     */
    public void setGroupAction(String groupAction) {
        this.groupAction = groupAction == null ? null : groupAction.trim();
    }

    /**
     * @return group_icon
     */
    public String getGroupIcon() {
        return groupIcon;
    }

    /**
     * @param groupIcon
     */
    public void setGroupIcon(String groupIcon) {
        this.groupIcon = groupIcon == null ? null : groupIcon.trim();
    }

    /**
     * @return group_grade
     */
    public Long getGroupGrade() {
        return groupGrade;
    }

    /**
     * @param groupGrade
     */
    public void setGroupGrade(Long groupGrade) {
        this.groupGrade = groupGrade;
    }

    /**
     * @return group_sort_code
     */
    public Integer getGroupSortCode() {
        return groupSortCode;
    }

    /**
     * @param groupSortCode
     */
    public void setGroupSortCode(Integer groupSortCode) {
        this.groupSortCode = groupSortCode;
    }

    @Transient
    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
