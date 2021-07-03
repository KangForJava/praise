/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: UserService
 * Author: kjy
 * Date: 2021/5/29 15:19
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.service;

import com.kjy.dto.UserDTO;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/29
 * @since 1.0.0
 */
public interface UserService {
    /**
     * @param id 要查询的用户的id
     * @return 用于前端展示的用户信息对象
     */
    UserDTO find(String id);
}
