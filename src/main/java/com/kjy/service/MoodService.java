/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: MoodService
 * Author: kjy
 * Date: 2021/5/29 15:22
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.service;

import com.kjy.domain.Mood;
import com.kjy.dto.MoodDTO;

import java.util.List;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/29
 * @since 1.0.0
 */
public interface MoodService {

    /**
     * @return 用于前端展示的说说信息对象集合
     */
    List<MoodDTO> findAll();

    /**
     * @param userId 点赞用户的id
     * @param moodId 被点赞说说的id
     * @return 点赞结果
     */
    boolean praiseMood(String userId, String moodId);

    /**
     * @param id 说说id
     * @return 查找到的说说对象
     */
    Mood findById(String id);

    /**
     * @param mood 包含更新信息的说说对象
     * @return 更新结果
     */
    boolean update(Mood mood);

    /**
     * @return 从redis缓存中查询到的说说对象列表
     */
    List<MoodDTO> findAllForRedis();

    /**
     * @param userId 点赞用户的id
     * @param moodId 被点赞说说的id
     * @return 点赞结果
     */
    boolean praiseMoodForRedis(String userId, String moodId);
}
