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
    public CgbdResult choiceQuestionByType(@RequestParam(value = "type", required = false) List<Byte> type) {
        return choiceQuestionService.choiceQuestionByType(type);
    }

    @PutMapping("/choiceQuestion")
    CgbdResult insertChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion) {
        return choiceQuestionService.insertChoiceQuestion(choiceQuestion);
    }
}
