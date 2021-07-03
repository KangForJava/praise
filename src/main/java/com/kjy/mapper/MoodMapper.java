/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: MoodMapper
 * Author: kjy
 * Date: 2021/5/29 10:54
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.mapper;

import com.kjy.domain.Mood;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/29
 * @since 1.0.0
 */
@Repository
public interface MoodMapper {

    /**
     * @return 查询到的说说对象集合
     */
    List<Mood> findAll();

    /**
     * @param id 要查询的说说id
     * @return 说说对象
     */
    Mood findById(String id);

    /**
     * @param mood 要更新信息的说说对象
     * @return 更新结果
     */
    boolean update(Mood mood);
}
