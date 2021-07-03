/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: UserMapper
 * Author: kjy
 * Date: 2021/5/29 10:52
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.mapper;

import com.kjy.domain.User;
import org.springframework.stereotype.Repository;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/29
 * @since 1.0.0
 */
@Repository
public interface UserMapper {

    /**
     * @param id 要查找的用户id
     * @return 用户对象
     */
    User find(String id);
}
