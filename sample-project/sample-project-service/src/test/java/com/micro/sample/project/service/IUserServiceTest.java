package com.micro.sample.project.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.sample.project.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class IUserServiceTest {

    @Autowired
    private IUserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void queryAll() throws JsonProcessingException {
        List<User> users = userService.queryAll();
        log.info("用户信息：{}", objectMapper.writeValueAsString(users));
    }
}
