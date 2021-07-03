/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: UserMoodPraiseRelService
 * Author: kjy
 * Date: 2021/5/29 18:03
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.service;

import com.kjy.domain.UserMoodPraiseRel;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/29
 * @since 1.0.0
 */
public interface UserMoodPraiseRelService {
    /**
     * @param userMoodPraiseRel 用户给说说点赞的记录
     * @return 记录保存的结果
     */
    boolean save(UserMoodPraiseRel userMoodPraiseRel);
}
