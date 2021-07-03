/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: UserMoodPraiseRel
 * Author: kjy
 * Date: 2021/5/29 10:47
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.domain;

import java.io.Serializable;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/29
 * @since 1.0.0
 */
public class UserMoodPraiseRel implements Serializable {

    /**
     * 主键
     */
    private String id;

    /**
     * 点赞用户id
     */
    private String userId;

    /**
     * 说说id
     */
    private String moodId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMoodId() {
        return moodId;
    }

    public void setMoodId(String moodId) {
        this.moodId = moodId;
    }
}
