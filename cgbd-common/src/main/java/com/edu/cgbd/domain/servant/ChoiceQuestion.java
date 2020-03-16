package com.edu.cgbd.domain.servant;

import java.util.Date;
import javax.persistence.*;

@Table(name = "choice_question")
public class ChoiceQuestion {
    @Id
    private String id;

    private Byte type;

    private Byte score;

    private String answer;

    private String title;

    private Long sort;

    private Byte state;

    @Column(name = "update_on")
    private Date updateOn;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "create_on")
    private Date createOn;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "is_delete")
    private Byte isDelete;

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
     * @return type
     */
    public Byte getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * @return score
     */
    public Byte getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Byte score) {
        this.score = score;
    }

    /**
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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
     * @return sort
     */
    public Long getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * @return state
     */
    public Byte getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * @return update_on
     */
    public Date getUpdateOn() {
        return updateOn;
    }

    /**
     * @param updateOn
     */
    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    /**
     * @return update_by
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * @return create_on
     */
    public Date getCreateOn() {
        return createOn;
    }

    /**
     * @param createOn
     */
    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    /**
     * @return create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * @return is_delete
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}