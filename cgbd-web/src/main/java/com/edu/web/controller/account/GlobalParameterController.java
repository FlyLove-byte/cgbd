package com.edu.web.controller.account;

import com.edu.cgbd.pojo.CgbdResult;
import com.edu.web.service.accountService.GlobalParameterService;
import com.edu.web.service.accountService.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GlobalParameterController {
    @Autowired
    GlobalParameterService globalParameterService;

    @GetMapping("/globalParameter")
    public CgbdResult globalParameterByKey(String key) {
        return globalParameterService.globalParameterByKey(key);
    }
}
