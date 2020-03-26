package com.edu.cgbd.controller;

import com.edu.cgbd.data.CgbdResultStatus;
import com.edu.cgbd.pojo.CgbdResult;
import com.edu.cgbd.service.GlobalParameterService;
import com.edu.cgbd.service.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GlobalParameterController {
    @Autowired
    GlobalParameterService globalParameterService;

    @GetMapping("/globalParameter")
    CgbdResult globalParameterByKey(@RequestParam(value = "key") String key) {
        try {
            return CgbdResult.ok(globalParameterService.globalParameterByKey(key));
        } catch (Exception e) {
            log.error("", e);
            return CgbdResult.build(CgbdResultStatus.Unknown_Error);
        }
    }
}
