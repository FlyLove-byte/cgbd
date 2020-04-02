package com.edu.web.client;

import com.edu.cgbd.domain.servant.ChoiceQuestion;
import com.edu.cgbd.pojo.CgbdResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "cgbd-servant")
public interface ServantServiceClient {

    @GetMapping(value = "servant/choiceQuestionByType", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CgbdResult choiceQuestionByType(@RequestParam(value = "type", required = false) List<Byte> type,
                                    @RequestParam(value = "state", required = false) Short state,
                                    @RequestParam(value = "delete", required = false) Byte delete);

    @PutMapping(value = "servant/choiceQuestion", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CgbdResult insertChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion);

    @DeleteMapping(value = "servant/choiceQuestion", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CgbdResult deleteChoiceQuestion(@RequestParam("type") List<String> ids);

    @PostMapping(value = "servant/choiceQuestion", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CgbdResult updateChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion);

    @PostMapping(value = "servant/deleteChoiceQuestion", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CgbdResult falseDeleteChoiceQuestion(@RequestParam("type") List<String> ids);
}
