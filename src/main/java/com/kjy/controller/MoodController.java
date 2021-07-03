/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: MoodController
 * Author: kjy
 * Date: 2021/5/29 18:10
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.controller;

import com.kjy.dto.MoodDTO;
import com.kjy.service.MoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/29
 * @since 1.0.0
 */
@Controller
@RequestMapping("/mood")
public class MoodController {
    @Resource
    private MoodService moodService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<MoodDTO> moodDTOList = moodService.findAll();
        model.addAttribute("moods", moodDTOList);
        return "mood";
    }

    @RequestMapping(value = "/praise/{moodId}", method = RequestMethod.GET)
    public String praise(Model model, @RequestParam(value = "userId") String userId, @PathVariable(value = "moodId") String moodId){
        boolean isPraise = moodService.praiseMood(userId, moodId);
        List<MoodDTO> moodDTOList = moodService.findAll();
        model.addAttribute("moods", moodDTOList);
        model.addAttribute("isPraise", isPraise);
        return "mood";
    }

    @GetMapping(value = "/praiseForRedis/{moodId}")
    public String praiseForRedis(Model model, @PathVariable(value = "moodId") String moodId, @RequestParam(value = "userId") String userId){
        userId = new Random().nextInt(100) + "";
        boolean isPraise = moodService.praiseMoodForRedis(userId, moodId);
        List<MoodDTO> moodDTOList = moodService.findAllForRedis();
        model.addAttribute("moods", moodDTOList);
        model.addAttribute("isPraise", isPraise);
        return "mood";
    }
}
