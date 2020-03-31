package com.edu.web.service.servantServer.impl;

import com.edu.cgbd.domain.servant.ChoiceQuestion;
import com.edu.cgbd.pojo.CgbdResult;
import com.edu.web.client.ServantServiceClient;
import com.edu.web.service.servantServer.ChoiceQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {

    @Autowired
    ServantServiceClient servantServiceClient;
    @Override
    public CgbdResult choiceQuestionByType(List<Byte> type) {
        return servantServiceClient.choiceQuestionByType(type);
    }

    @Override
    public CgbdResult insertChoiceQuestion(ChoiceQuestion choiceQuestion) {
        return servantServiceClient.insertChoiceQuestion(choiceQuestion);
    }

    @Override
    public CgbdResult deleteChoiceQuestion(List<String> ids) {
        return servantServiceClient.deleteChoiceQuestion(ids);
    }
}
