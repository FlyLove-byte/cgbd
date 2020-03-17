package com.edu.cgbd.controller;

import com.edu.cgbd.data.CgbdResultStatus;
import com.edu.cgbd.pojo.CgbdResult;
import com.edu.cgbd.service.ChoiceQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ChoiceQuestionController {
    @Autowired
    ChoiceQuestionService choiceQuestionService;

    @GetMapping("/choiceQuestionByType/{type}")
    CgbdResult choiceQuestionByType(@PathVariable Byte type) {
        try {
            return CgbdResult.ok(choiceQuestionService.choiceQuestionByType(type));
        } catch (Exception e) {
            log.error("", e);
            return CgbdResult.build(CgbdResultStatus.Unknown_Error);
        }
    }
}

