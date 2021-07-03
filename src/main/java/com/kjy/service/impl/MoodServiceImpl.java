/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: MoodServiceImpl
 * Author: kjy
 * Date: 2021/5/29 15:47
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.service.impl;

import com.kjy.domain.Mood;
import com.kjy.domain.User;
import com.kjy.domain.UserMoodPraiseRel;
import com.kjy.dto.MoodDTO;
import com.kjy.mapper.MoodMapper;
import com.kjy.mapper.UserMapper;
import com.kjy.mapper.UserMoodPraiseRelMapper;
import com.kjy.service.MoodService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/29
 * @since 1.0.0
 */
@Service
public class MoodServiceImpl implements MoodService {

    @Resource
    private MoodMapper moodMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserMoodPraiseRelMapper userMoodPraiseRelMapper;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * PRAISE_HASH_KEY是一个key,它所对应的value是一个set集合,
     * 这个集合里的元素是moodId,也就是被点赞的说说的id
     */
    private static final String PRAISE_HASH_KEY =
            "springmv.mybatis.boot.mood.id.list.key";


    @Override
    public List<MoodDTO> findAll() {
        List<Mood> moodList = moodMapper.findAll();

        return convertMoodMapper(moodList);
    }

    @Override
    public boolean praiseMood(String userId, String moodId) {
        UserMoodPraiseRel userMoodPraiseRel = new UserMoodPraiseRel();
        userMoodPraiseRel.setMoodId(moodId);
        userMoodPraiseRel.setUserId(userId);
        userMoodPraiseRelMapper.save(userMoodPraiseRel);

        Mood mood = moodMapper.findById(moodId);
        mood.setPraiseNum(mood.getPraiseNum() + 1);
        moodMapper.update(mood);

        return true;
    }

    @Override
    public Mood findById(String id) {
        return moodMapper.findById(id);
    }

    @Override
    public boolean update(Mood mood) {
        return moodMapper.update(mood);
    }

    @Override
    public List<MoodDTO> findAllForRedis() {
        List<Mood> moodList = moodMapper.findAll();
        List<MoodDTO> moodDTOList = new ArrayList<>();
        for(Mood mood : moodList){
            MoodDTO moodDTO = new MoodDTO();
            moodDTO.setUserId(mood.getUserId());
            moodDTO.setPublishTime(mood.getPublishTime());
            moodDTO.setPraiseNum(mood.getPraiseNum() + redisTemplate.opsForSet().size(mood.getId()).intValue());
            moodDTO.setContent(mood.getContent());
            moodDTO.setId(mood.getId());

            User user = userMapper.find(mood.getUserId());
            moodDTO.setUserAccount(user.getAccount());
            moodDTO.setUserName(user.getName());

            moodDTOList.add(moodDTO);
        }
        return moodDTOList;
    }

    @Override
    public boolean praiseMoodForRedis(String userId, String moodId) {
        //先将被点赞的说说id存储到集合里面
        redisTemplate.opsForSet().add(PRAISE_HASH_KEY, moodId);
        //再将点赞记录保存到moodId对应的集合里
        redisTemplate.opsForSet().add(moodId, userId);
        return false;
    }

    private List<MoodDTO> convertMoodMapper(List<Mood> moodList){
        List<MoodDTO> moodDTOList = new ArrayList<>();
        for(Mood mood : moodList){
            MoodDTO moodDTO = new MoodDTO();
            moodDTO.setId(mood.getId());
            moodDTO.setContent(mood.getContent());
            moodDTO.setPraiseNum(mood.getPraiseNum());
            moodDTO.setPublishTime(mood.getPublishTime());
            moodDTO.setUserId(mood.getUserId());

            User user = userMapper.find(mood.getUserId());
            moodDTO.setUserName(user.getName());
            moodDTO.setUserAccount(user.getAccount());

            moodDTOList.add(moodDTO);
        }
        return moodDTOList;
    }
}
