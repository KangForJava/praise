/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: PraiseDataSaveDBJob
 * Author: kjy
 * Date: 2021/5/30 16:50
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.job;

import com.kjy.domain.Mood;
import com.kjy.domain.UserMoodPraiseRel;
import com.kjy.service.MoodService;
import com.kjy.service.UserMoodPraiseRelService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/30
 * @since 1.0.0
 */
@Component
@Configurable
@EnableScheduling
public class PraiseDataSaveJob {
    @Resource
    private RedisTemplate redisTemplate;

    private static final String PRAISE_HASH_KEY =
            "springmv.mybatis.boot.mood.id.list.key";

    @Resource
    private UserMoodPraiseRelService userMoodPraiseRelService;
    @Resource
    private MoodService moodService;

    @Scheduled(cron = "*/10 * *  * * * ")
    public void savePraiseDataToDB(){
        Set<String> moodIds = redisTemplate.opsForSet().members(PRAISE_HASH_KEY);
        if(moodIds != null){
            for(String moodId : moodIds){
                Set<String> userIds = redisTemplate.opsForSet().members(moodId);
                if(userIds != null){
                    for(String userId : userIds){
                        UserMoodPraiseRel userMoodPraiseRel = new UserMoodPraiseRel();
                        userMoodPraiseRel.setUserId(userId);
                        userMoodPraiseRel.setMoodId(moodId);
                        userMoodPraiseRelService.save(userMoodPraiseRel);
                    }
                    Mood mood = moodService.findById(moodId);
                    mood.setPraiseNum(mood.getPraiseNum() +
                            redisTemplate.opsForSet().size(moodId).intValue());
                    moodService.update(mood);
                }
                redisTemplate.delete(moodId);
            }
        }
        redisTemplate.delete(PRAISE_HASH_KEY);
    }

}
