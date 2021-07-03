/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: Mood
 * Author: kjy
 * Date: 2021/5/29 10:44
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/29
 * @since 1.0.0
 */
public class Mood implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 说说内容
     */
    private String content;

    /**
     * 点赞数量
     */
    private Integer praiseNum;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 发表时间
     */
    private Date publishTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}

