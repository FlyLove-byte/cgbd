package com.edu.cgbd.domain.account;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "lang_detail")
public class LangDetail implements Serializable {
    private Long id;

    @Column(name = "lang_key")
    private String langKey;

    @Column(name = "zh_tw")
    private String zhTw;

    @Column(name = "zh_cn")
    private String zhCn;

    private String en;

    private String jp;

    @Column(name = "update_by")
    private Long updateBy;

    @Column(name = "update_on")
    private Date updateOn;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String reserve4;

    private String reserve5;

    private String reserve6;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return lang_key
     */
    public String getLangKey() {
        return langKey;
    }

    /**
     * @param langKey
     */
    public void setLangKey(String langKey) {
        this.langKey = langKey == null ? null : langKey.trim();
    }

    /**
     * @return zh_tw
     */
    public String getZhTw() {
        return zhTw;
    }

    /**
     * @param zhTw
     */
    public void setZhTw(String zhTw) {
        this.zhTw = zhTw == null ? null : zhTw.trim();
    }

    /**
     * @return zh_cn
     */
    public String getZhCn() {
        return zhCn;
    }

    /**
     * @param zhCn
     */
    public void setZhCn(String zhCn) {
        this.zhCn = zhCn == null ? null : zhCn.trim();
    }

    /**
     * @return en
     */
    public String getEn() {
        return en;
    }

    /**
     * @param en
     */
    public void setEn(String en) {
        this.en = en == null ? null : en.trim();
    }

    /**
     * @return jp
     */
    public String getJp() {
        return jp;
    }

    /**
     * @param jp
     */
    public void setJp(String jp) {
        this.jp = jp == null ? null : jp.trim();
    }

    /**
     * @return update_by
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
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
     * @return reserve1
     */
    public String getReserve1() {
        return reserve1;
    }

    /**
     * @param reserve1
     */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    /**
     * @return reserve2
     */
    public String getReserve2() {
        return reserve2;
    }

    /**
     * @param reserve2
     */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    /**
     * @return reserve3
     */
    public String getReserve3() {
        return reserve3;
    }

    /**
     * @param reserve3
     */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }

    /**
     * @return reserve4
     */
    public String getReserve4() {
        return reserve4;
    }

    /**
     * @param reserve4
     */
    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4 == null ? null : reserve4.trim();
    }

    /**
     * @return reserve5
     */
    public String getReserve5() {
        return reserve5;
    }

    /**
     * @param reserve5
     */
    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5 == null ? null : reserve5.trim();
    }

    /**
     * @return reserve6
     */
    public String getReserve6() {
        return reserve6;
    }

    /**
     * @param reserve6
     */
    public void setReserve6(String reserve6) {
        this.reserve6 = reserve6 == null ? null : reserve6.trim();
    }
}