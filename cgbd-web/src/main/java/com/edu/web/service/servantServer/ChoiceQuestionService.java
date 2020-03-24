package com.edu.web.service.servantServer;

import com.edu.cgbd.domain.servant.ChoiceQuestion;
import com.edu.cgbd.pojo.CgbdResult;

import java.util.List;

public interface ChoiceQuestionService {
    CgbdResult choiceQuestionByType(List<Byte> type);

    CgbdResult insertChoiceQuestion(ChoiceQuestion choiceQuestion);
}
