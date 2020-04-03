package com.edu.web.controller.servant;

import com.edu.cgbd.data.CgbdResultStatus;
import com.edu.cgbd.domain.servant.ChoiceQuestion;
import com.edu.cgbd.pojo.CgbdResult;
import com.edu.web.service.servantServer.ChoiceQuestionService;
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
    public CgbdResult choiceQuestionByType(@RequestParam(value = "type", required = false) List<Byte> type,
                                           @RequestParam(value = "state", required = false) Short state,
                                           @RequestParam(value = "delete", required = false) Byte delete) {
        return choiceQuestionService.choiceQuestionByType(type, state, delete);
    }

    @PutMapping("/choiceQuestion")
    CgbdResult insertChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion) {
        return choiceQuestionService.insertChoiceQuestion(choiceQuestion);
    }

    @DeleteMapping("/choiceQuestion")
    public CgbdResult deleteChoiceQuestion(@RequestParam(value = "ids") List<String> ids) {
        return choiceQuestionService.deleteChoiceQuestion(ids);
    }

    @PostMapping("/choiceQuestion")
    public CgbdResult updateChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion) {
        return choiceQuestionService.updateChoiceQuestion(choiceQuestion);
    }

    @PostMapping("/deleteChoiceQuestion")
    public CgbdResult falseDeleteChoiceQuestion(@RequestBody List<String> ids) {
        return choiceQuestionService.isDeleteChoiceQuestion(ids, (byte) 1);
    }

    @PostMapping("/publishChoiceQuestion")
    public CgbdResult publishChoiceQuestion(@RequestBody List<String> ids) {
        return choiceQuestionService.publishChoiceQuestion(ids);
    }

    @PostMapping("/reductionChoiceQuestion")
    public CgbdResult reductionChoiceQuestion(@RequestBody List<String> ids) {
        return choiceQuestionService.isDeleteChoiceQuestion(ids, (byte) 0);
    }
}
