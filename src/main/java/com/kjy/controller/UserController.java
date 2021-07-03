/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: UserController
 * Author: kjy
 * Date: 2021/5/29 18:08
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.controller;

import com.kjy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * (一句话描述功能)<br>
 *
 *
 * @author kjy
 * @date 2021/5/29
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

}
