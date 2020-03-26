package com.edu.web.service.accountService.impl;

import com.edu.cgbd.data.CgbdResultStatus;
import com.edu.cgbd.pojo.CgbdResult;
import com.edu.web.client.AccountServiceClient;
import com.edu.web.service.accountService.GlobalParameterService;
import com.edu.web.service.accountService.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GlobalParameterServiceImpl implements GlobalParameterService {
    @Autowired
    AccountServiceClient accountServiceClient;

    @Override
    public CgbdResult globalParameterByKey(String key) {
        return accountServiceClient.globalParameterByKey(key);
    }
}
