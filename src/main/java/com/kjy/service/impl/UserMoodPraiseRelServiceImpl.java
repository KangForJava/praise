/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: UserMoodPraiseRelServiceImpl
 * Author: kjy
 * Date: 2021/5/29 18:05
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.service.impl;

import com.kjy.domain.UserMoodPraiseRel;
import com.kjy.mapper.UserMoodPraiseRelMapper;
import com.kjy.service.UserMoodPraiseRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/29
 * @since 1.0.0
 */
@Service
public class UserMoodPraiseRelServiceImpl implements UserMoodPraiseRelService {

    @Resource
    private UserMoodPraiseRelMapper userMoodPraiseRelMapper;

    @Override
    public boolean save(UserMoodPraiseRel userMoodPraiseRel) {
        return userMoodPraiseRelMapper.save(userMoodPraiseRel);
    }
}
