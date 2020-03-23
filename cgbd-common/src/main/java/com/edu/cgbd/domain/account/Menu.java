package com.edu.cgbd.domain.account;

import javax.persistence.*;
import java.io.Serializable;

public class Menu implements Serializable {
    @Id
    private Long id;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * route
     */
    @Column(name = "menu_route")
    private String menuRoute;

    /**
     * action
     */
    @Column(name = "menu_action")
    private String menuAction;

    /**
     * 图标
     */
    @Column(name = "menu_icon")
    private String menuIcon;

    /**
     * 显示顺序
     */
    @Column(name = "menu_sort_code")
    private Long menuSortCode;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 获取route
     *
     * @return menu_route - route
     */
    public String getMenuRoute() {
        return menuRoute;
    }

    /**
     * 设置route
     *
     * @param menuRoute route
     */
    public void setMenuRoute(String menuRoute) {
        this.menuRoute = menuRoute == null ? null : menuRoute.trim();
    }

    /**
     * 获取action
     *
     * @return menu_action - action
     */
    public String getMenuAction() {
        return menuAction;
    }

    /**
     * 设置action
     *
     * @param menuAction action
     */
    public void setMenuAction(String menuAction) {
        this.menuAction = menuAction == null ? null : menuAction.trim();
    }

    /**
     * 获取图标
     *
     * @return menu_icon - 图标
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * 设置图标
     *
     * @param menuIcon 图标
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    /**
     * 获取显示顺序
     *
     * @return menu_sort_code - 显示顺序
     */
    public Long getMenuSortCode() {
        return menuSortCode;
    }

    /**
     * 设置显示顺序
     *
     * @param menuSortCode 显示顺序
     */
    public void setMenuSortCode(Long menuSortCode) {
        this.menuSortCode = menuSortCode;
    }
}
