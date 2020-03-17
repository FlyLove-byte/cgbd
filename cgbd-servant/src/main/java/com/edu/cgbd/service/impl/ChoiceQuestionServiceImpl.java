package com.edu.cgbd.service.impl;

import com.edu.cgbd.data.ConstDefine;
import com.edu.cgbd.domain.servant.ChoiceQuestion;
import com.edu.cgbd.domain.servant.ChoiceQuestionExample;
import com.edu.cgbd.mapper.ChoiceQuestionMapper;
import com.edu.cgbd.service.ChoiceQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {

    @Autowired
    ChoiceQuestionMapper choiceQuestionMapper;
    @Override
    public List<ChoiceQuestion> choiceQuestionByType(Byte type) {
        ChoiceQuestionExample choiceQuestionExample = new ChoiceQuestionExample();
        ChoiceQuestionExample.Criteria criteria = choiceQuestionExample.createCriteria();
        criteria.andTypeEqualTo(type);
        criteria.andStateEqualTo(ConstDefine.STATE_ENABLE);
        return choiceQuestionMapper.selectByExample(choiceQuestionExample);
    }
}
