package com.edu.cgbd.service;

import com.edu.cgbd.domain.servant.ChoiceQuestion;

import java.util.List;

public interface ChoiceQuestionService {
    List<ChoiceQuestion> choiceQuestionByType(List<Byte> type);

    int insertChoiceQuestion(ChoiceQuestion choiceQuestion);
}
