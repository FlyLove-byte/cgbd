package com.edu.cgbd.controller;

import com.edu.cgbd.data.CgbdResultStatus;
import com.edu.cgbd.pojo.CgbdResult;
import com.edu.cgbd.service.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @GetMapping("/langs")
    CgbdResult listAllLanguage() {
        try {
            return CgbdResult.ok(languageService.langs());
        } catch (Exception e) {
            log.error("", e);
            return CgbdResult.build(CgbdResultStatus.Unknown_Error);
        }
    }
}
