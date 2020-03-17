package com.edu.web.controller.servant;

import com.edu.cgbd.pojo.CgbdResult;
import com.edu.web.service.servantServer.ChoiceQuestionService;
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
    public CgbdResult choiceQuestionByType(@PathVariable byte type) {
        return choiceQuestionService.choiceQuestionByType(type);
    }
}
