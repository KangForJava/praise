/*
 * Copyright (C), 2020-2021, 计算机科学与技术学院
 * FileName: UserServiceImpl
 * Author: kjy
 * Date: 2021/5/29 15:24
 * Description:
 * History:
 * <author>    <time>    <version>    <desc>
 * 作者姓名     修改时间     版本号       描述
 */
package com.kjy.service.impl;

import com.kjy.domain.User;
import com.kjy.dto.UserDTO;
import com.kjy.mapper.UserMapper;
import com.kjy.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDTO find(String id) {
        return convertUserDTO(userMapper.find(id));
    }

    private UserDTO convertUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAccount(user.getAccount());
        return userDTO;
    }
}
