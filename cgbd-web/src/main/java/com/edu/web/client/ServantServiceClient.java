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
    CgbdResult choiceQuestionByType(@RequestParam(value = "type", required = false) List<Byte> type);

    @PutMapping(value = "servant/choiceQuestionByType", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CgbdResult insertChoiceQuestion(@RequestBody ChoiceQuestion choiceQuestion);
}
