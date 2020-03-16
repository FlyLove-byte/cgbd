package com.edu.web.service.accountService.impl;

import com.edu.cgbd.pojo.CgbdResult;
import com.edu.web.client.AccountServiceClient;
import com.edu.web.service.accountService.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MenuServiceImpl implements MenuService {
    @Autowired
    AccountServiceClient accountServiceClient;

    @Override
    public CgbdResult menuGroups() {
        return accountServiceClient.menuGroups();
    }
}
