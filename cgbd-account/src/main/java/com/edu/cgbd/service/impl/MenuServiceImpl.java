package com.edu.cgbd.service.impl;

import com.edu.cgbd.domain.account.*;
import com.edu.cgbd.mapper.MenuGroupMapper;
import com.edu.cgbd.mapper.MenuGroupMappingMapper;
import com.edu.cgbd.mapper.MenuMapper;
import com.edu.cgbd.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@CacheConfig(cacheNames = "menu")
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuGroupMapper menuGroupMapper;
    @Autowired
    MenuGroupMappingMapper menuGroupMappingMapper;

    @Override
    @Cacheable(value = "menu", key = "#root.methodName")
    public List<MenuGroup> menuGroups() {
        MenuGroupExample menuGroupExample = new MenuGroupExample();
        menuGroupExample.setOrderByClause("group_sort_code asc");
        List<MenuGroup> menuGroups = menuGroupMapper.selectByExample(menuGroupExample);

        for (int i = 0;i<menuGroups.size();i++){
            MenuGroupMappingExample mappingExample = new MenuGroupMappingExample();
            mappingExample.setOrderByClause("menu_sort_code asc");
            MenuGroupMappingExample.Criteria criteria = mappingExample.createCriteria();
            criteria.andGroupIdEqualTo(menuGroups.get(i).getId());
            List<Long> menuIds = menuGroupMappingMapper.selectByExample(mappingExample).stream().map(p -> p.getMenuId()).collect(Collectors.toList());

            List<Menu> menus = new ArrayList<>();
            menuIds.forEach(p->{
                menus.add(menuMapper.selectByPrimaryKey(p));
            });

            menuGroups.get(i).setMenus(menus);
        }
        return menuGroups;
    }
}
