package com.edu.cgbd.domain.servant;

import javax.persistence.*;

@Table(name = "choice_question_option")
public class ChoiceQuestionOption {
    @Id
    private String id;

    @Column(name = "choice_question_id")
    private String choiceQuestionId;

    private String title;

    private String value;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return choice_question_id
     */
    public String getChoiceQuestionId() {
        return choiceQuestionId;
    }

    /**
     * @param choiceQuestionId
     */
    public void setChoiceQuestionId(String choiceQuestionId) {
        this.choiceQuestionId = choiceQuestionId == null ? null : choiceQuestionId.trim();
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}