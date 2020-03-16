package com.edu.cgbd.domain.account;

import javax.persistence.*;
import java.util.List;

@Table(name = "menu_group")
public class MenuGroup {
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

    /**
     * 显示顺序
     */
    @Column(name = "group_sort_code")
    private Long groupSortCode;

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
     * 获取显示顺序
     *
     * @return group_sort_code - 显示顺序
     */
    public Long getGroupSortCode() {
        return groupSortCode;
    }

    /**
     * 设置显示顺序
     *
     * @param groupSortCode 显示顺序
     */
    public void setGroupSortCode(Long groupSortCode) {
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
