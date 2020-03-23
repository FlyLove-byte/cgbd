package com.edu.cgbd.domain.account;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "menu_group_mapping")
public class MenuGroupMapping implements Serializable {
    /**
     * 组Id
     */
    @Id
    @Column(name = "group_id")
    private Long groupId;

    /**
     * 菜单id
     */
    @Id
    @Column(name = "menu_id")
    private Long menuId;

    /**
     * 获取组Id
     *
     * @return group_id - 组Id
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置组Id
     *
     * @param groupId 组Id
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取菜单id
     *
     * @return menu_id - 菜单id
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单id
     *
     * @param menuId 菜单id
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
