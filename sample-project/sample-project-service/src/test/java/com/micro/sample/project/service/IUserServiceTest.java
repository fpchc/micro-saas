package com.micro.sample.project.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.micro.sample.project.api.commands.CreateUserCmd;
import com.micro.sample.project.config.DefaultObjectMapper;
import com.micro.sample.project.api.dto.UserDto;
import com.micro.sample.project.api.query.UserQuery;
import com.micro.sample.project.resp.PageQuery;
import com.micro.sample.project.resp.PageVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private DefaultObjectMapper objectMapper;

    @Test
    public void query() {
        PageVo<UserDto> query = userService.query(PageQuery.<UserQuery>builder().build());
        log.info("用户信息：{}", objectMapper.writeValueAsString(query));
    }

    @Test
    public void create() {
        CreateUserCmd cmd = CreateUserCmd.builder()
                .loginName("pch")
                .username("pch")
                .email("254621340@qq.com")
                .password("pch")
                .telephone("123456")
                .build();
        Long userId = userService.create(cmd);
        Assert.assertNotNull(userId);
    }
}
