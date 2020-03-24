package com.edu.cgbd.service.impl;

import com.edu.cgbd.data.ConstDefine;
import com.edu.cgbd.domain.servant.ChoiceQuestion;
import com.edu.cgbd.domain.servant.ChoiceQuestionExample;
import com.edu.cgbd.domain.servant.ChoiceQuestionOption;
import com.edu.cgbd.domain.servant.ChoiceQuestionOptionExample;
import com.edu.cgbd.mapper.ChoiceQuestionMapper;
import com.edu.cgbd.mapper.ChoiceQuestionOptionMapper;
import com.edu.cgbd.service.ChoiceQuestionService;
import com.edu.cgbd.utils.FormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {

    @Autowired
    ChoiceQuestionMapper choiceQuestionMapper;

    @Autowired
    ChoiceQuestionOptionMapper choiceQuestionOptionMapper;

    @Override
    public List<ChoiceQuestion> choiceQuestionByType(List<Byte> type) {
        ChoiceQuestionExample choiceQuestionExample = new ChoiceQuestionExample();
        ChoiceQuestionExample.Criteria criteria = choiceQuestionExample.createCriteria();
        if(type != null) criteria.andTypeIn(type);
        criteria.andStateEqualTo(ConstDefine.STATE_ENABLE);
        List<ChoiceQuestion> choiceQuestions = choiceQuestionMapper.selectByExample(choiceQuestionExample);
        for(ChoiceQuestion choiceQuestion : choiceQuestions){
            ChoiceQuestionOptionExample choiceQuestionOptionExample = new ChoiceQuestionOptionExample();
            ChoiceQuestionOptionExample.Criteria optionExampleCriteria = choiceQuestionOptionExample.createCriteria();
            optionExampleCriteria.andChoiceQuestionIdEqualTo(choiceQuestion.getId());
            List<ChoiceQuestionOption> choiceQuestionOptions = choiceQuestionOptionMapper.selectByExample(choiceQuestionOptionExample);
            choiceQuestion.setChoiceQuestionOptions(choiceQuestionOptions);
        }
        return choiceQuestions;
    }

    @Override
    public int insertChoiceQuestion(ChoiceQuestion choiceQuestion) {
        choiceQuestion.setId(FormatUtil.getUUID());
        choiceQuestionMapper.insertSelective(choiceQuestion);
        return 0;
    }
}
