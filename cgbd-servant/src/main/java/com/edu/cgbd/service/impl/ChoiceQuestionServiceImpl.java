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

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {

    @Autowired
    ChoiceQuestionMapper choiceQuestionMapper;

    @Autowired
    ChoiceQuestionOptionMapper choiceQuestionOptionMapper;

    @Override
    public List<ChoiceQuestion> choiceQuestionByType(List<Byte> type, Short state, Byte delete) {
        ChoiceQuestionExample choiceQuestionExample = new ChoiceQuestionExample();
        ChoiceQuestionExample.Criteria criteria = choiceQuestionExample.createCriteria();
        if (type != null) criteria.andTypeIn(type);
        if (state != null) criteria.andStateEqualTo(state);
        if (delete != null) criteria.andIsDeleteEqualTo(delete);
        List<ChoiceQuestion> choiceQuestions = choiceQuestionMapper.selectByExample(choiceQuestionExample);
        for (ChoiceQuestion choiceQuestion : choiceQuestions) {
            ChoiceQuestionOptionExample choiceQuestionOptionExample = new ChoiceQuestionOptionExample();
            choiceQuestionOptionExample.setOrderByClause("title ASC");
            ChoiceQuestionOptionExample.Criteria optionExampleCriteria = choiceQuestionOptionExample.createCriteria();
            optionExampleCriteria.andChoiceQuestionIdEqualTo(choiceQuestion.getId());
            List<ChoiceQuestionOption> choiceQuestionOptions = choiceQuestionOptionMapper.selectByExample(choiceQuestionOptionExample);
            choiceQuestion.setChoiceQuestionOptions(choiceQuestionOptions);
        }
        return choiceQuestions;
    }

    @Override
    public int insertChoiceQuestion(ChoiceQuestion choiceQuestion) {
        String choiceQuestionId = FormatUtil.getUUID();
        choiceQuestion.setId(choiceQuestionId);
        choiceQuestionMapper.insertSelective(choiceQuestion);
        List<ChoiceQuestionOption> choiceQuestionOptions = choiceQuestion.getChoiceQuestionOptions();
        for (ChoiceQuestionOption choiceQuestionOption : choiceQuestionOptions) {
            choiceQuestionOption.setId(FormatUtil.getUUID());
            choiceQuestionOption.setChoiceQuestionId(choiceQuestionId);
            choiceQuestionOptionMapper.insert(choiceQuestionOption);
        }
        return 0;
    }

    @Override
    public int deleteChoiceQuestion(List<String> ids) {
        ChoiceQuestionExample choiceQuestionExample = new ChoiceQuestionExample();
        ChoiceQuestionExample.Criteria criteria = choiceQuestionExample.createCriteria();
        criteria.andIdIn(ids);
        return choiceQuestionMapper.deleteByExample(choiceQuestionExample);
    }

    @Override
    public int updateChoiceQuestion(ChoiceQuestion choiceQuestion) {
        choiceQuestion.setUpdateOn(new Date());
        choiceQuestionMapper.updateByPrimaryKeySelective(choiceQuestion);

        ChoiceQuestionOptionExample choiceQuestionOptionExample = new ChoiceQuestionOptionExample();
        ChoiceQuestionOptionExample.Criteria criteria = choiceQuestionOptionExample.createCriteria();
        criteria.andChoiceQuestionIdEqualTo(choiceQuestion.getId());
        choiceQuestionOptionMapper.deleteByExample(choiceQuestionOptionExample);

        for (ChoiceQuestionOption choiceQuestionOption : choiceQuestion.getChoiceQuestionOptions()) {
            choiceQuestionOption.setId(FormatUtil.getUUID());
            choiceQuestionOption.setChoiceQuestionId(choiceQuestion.getId());
            choiceQuestionOptionMapper.insert(choiceQuestionOption);
        }
        return 0;
    }

    @Override
    public int isDeleteChoiceQuestion(List<String> ids, Byte isDel) {
        ChoiceQuestionExample choiceQuestionExample = new ChoiceQuestionExample();
        ChoiceQuestionExample.Criteria criteria = choiceQuestionExample.createCriteria();
        criteria.andIdIn(ids);
        List<ChoiceQuestion> choiceQuestions = choiceQuestionMapper.selectByExample(choiceQuestionExample);
        for (ChoiceQuestion choiceQuestion : choiceQuestions) {
            choiceQuestion.setIsDelete(isDel);
            choiceQuestionMapper.updateByPrimaryKeySelective(choiceQuestion);
        }
        return 0;
    }

    @Override
    public int publishChoiceQuestion(List<String> ids) {
        ChoiceQuestionExample choiceQuestionExample = new ChoiceQuestionExample();
        ChoiceQuestionExample.Criteria criteria = choiceQuestionExample.createCriteria();
        criteria.andIdIn(ids);
        List<ChoiceQuestion> choiceQuestions = choiceQuestionMapper.selectByExample(choiceQuestionExample);
        for (ChoiceQuestion choiceQuestion : choiceQuestions) {
            choiceQuestion.setState((byte) 2);
            choiceQuestionMapper.updateByPrimaryKeySelective(choiceQuestion);
        }
        return 0;
    }
}
