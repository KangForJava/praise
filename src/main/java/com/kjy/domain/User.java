/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: User
 * Author: kjy
 * Date: 2021/5/29 10:40
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
public class User implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 账户
     */
    private String account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
