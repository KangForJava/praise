/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: RedisTest
 * Author: kjy
 * Date: 2021/5/30 15:00
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.test;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/30
 * @since 1.0.0
 */

public class RedisTest extends BaseJunit4Test {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("name", "ay");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println("value of name is:" + name);
    }
}
