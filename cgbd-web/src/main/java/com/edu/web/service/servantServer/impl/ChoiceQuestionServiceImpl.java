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
    public CgbdResult choiceQuestionByType(List<Byte> type, Short state, Byte delete) {
        return servantServiceClient.choiceQuestionByType(type, state, delete);
    }

    @Override
    public CgbdResult insertChoiceQuestion(ChoiceQuestion choiceQuestion) {
        return servantServiceClient.insertChoiceQuestion(choiceQuestion);
    }

    @Override
    public CgbdResult deleteChoiceQuestion(List<String> ids) {
        return servantServiceClient.deleteChoiceQuestion(ids);
    }

    @Override
    public CgbdResult updateChoiceQuestion(ChoiceQuestion choiceQuestion) {
        return servantServiceClient.updateChoiceQuestion(choiceQuestion);
    }

    @Override
    public CgbdResult isDeleteChoiceQuestion(List<String> ids, Byte idDel) {
        return servantServiceClient.isDeleteChoiceQuestion(ids, idDel);
    }

    @Override
    public CgbdResult publishChoiceQuestion(List<String> ids) {
        return servantServiceClient.publishChoiceQuestion(ids);
    }
}
