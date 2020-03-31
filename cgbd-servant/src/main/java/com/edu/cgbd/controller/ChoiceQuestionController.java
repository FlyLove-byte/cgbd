package com.edu.cgbd.controller;

import com.edu.cgbd.data.CgbdResultStatus;
import com.edu.cgbd.domain.servant.ChoiceQuestion;
import com.edu.cgbd.pojo.CgbdResult;
import com.edu.cgbd.service.ChoiceQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ChoiceQuestionController {
    @Autowired
    ChoiceQuestionService choiceQuestionService;

    @GetMapping("/choiceQuestionByType")
    CgbdResult choiceQuestionByType(@RequestParam(value = "type", required = false) List<Byte> type) {
        try {
            return CgbdResult.ok(choiceQuestionService.choiceQuestionByType(type));
        } catch (Exception e) {
            log.error("", e);
            return CgbdResult.build(CgbdResultStatus.Unknown_Error);
        }
    }

    @PutMapping("/choiceQuestion")
    CgbdResult insertChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion) {
        try {
            return CgbdResult.ok(choiceQuestionService.insertChoiceQuestion(choiceQuestion));
        } catch (Exception e) {
            log.error("", e);
            return CgbdResult.build(CgbdResultStatus.Unknown_Error);
        }
    }

    @DeleteMapping("/choiceQuestion")
    CgbdResult deleteChoiceQuestion(@RequestParam("type") List<String> ids) {
        try {
            return CgbdResult.ok(choiceQuestionService.deleteChoiceQuestion(ids));
        } catch (Exception e) {
            log.error("", e);
            return CgbdResult.build(CgbdResultStatus.Unknown_Error);
        }
    }
}

