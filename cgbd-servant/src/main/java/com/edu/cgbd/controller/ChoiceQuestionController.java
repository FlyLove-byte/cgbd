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
    CgbdResult choiceQuestionByType(@RequestParam(value = "type", required = false) List<Byte> type,
                                    @RequestParam(value = "state", required = false) Short state,
                                    @RequestParam(value = "delete", required = false) Byte delete) {
        try {
            return CgbdResult.ok(choiceQuestionService.choiceQuestionByType(type, state, delete));
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

    @PostMapping("/choiceQuestion")
    CgbdResult updateChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion) {
        try {
            return CgbdResult.ok(choiceQuestionService.updateChoiceQuestion(choiceQuestion));
        } catch (Exception e) {
            log.error("", e);
            return CgbdResult.build(CgbdResultStatus.Unknown_Error);
        }
    }

    @PostMapping("/isDeleteChoiceQuestion")
    CgbdResult isDeleteChoiceQuestion(@RequestParam("type") List<String> ids, @RequestParam("isDel") Byte isDel) {
        try {
            return CgbdResult.ok(choiceQuestionService.isDeleteChoiceQuestion(ids, isDel));
        } catch (Exception e) {
            log.error("", e);
            return CgbdResult.build(CgbdResultStatus.Unknown_Error);
        }
    }

    @PostMapping("/publishChoiceQuestion")
    CgbdResult publishChoiceQuestion(@RequestParam("type") List<String> ids) {
        try {
            return CgbdResult.ok(choiceQuestionService.publishChoiceQuestion(ids));
        } catch (Exception e) {
            log.error("", e);
            return CgbdResult.build(CgbdResultStatus.Unknown_Error);
        }
    }
}

