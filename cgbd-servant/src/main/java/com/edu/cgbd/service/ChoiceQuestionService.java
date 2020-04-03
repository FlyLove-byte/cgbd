package com.edu.cgbd.service;

import com.edu.cgbd.domain.servant.ChoiceQuestion;

import java.util.List;

public interface ChoiceQuestionService {
    List<ChoiceQuestion> choiceQuestionByType(List<Byte> type, Short state, Byte delete);

    int insertChoiceQuestion(ChoiceQuestion choiceQuestion);

    int deleteChoiceQuestion(List<String> ids);

    int updateChoiceQuestion(ChoiceQuestion choiceQuestion);

    int isDeleteChoiceQuestion(List<String> ids, Byte isDel);

    int publishChoiceQuestion(List<String> ids);
}
