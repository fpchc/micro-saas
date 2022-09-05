package com.micro.sample.project.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.sample.project.dto.UserDto;
import com.micro.sample.project.model.User;
import com.micro.sample.project.query.PageQuery;
import com.micro.sample.project.query.UserQuery;
import com.micro.sample.project.resp.RespResult;
import com.micro.sample.project.service.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "user", description = "系统管理->用户管理")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @Operation(summary = "用户条件查询")
    @GetMapping("/query")
    public RespResult<Page<UserDto>> query(@RequestBody PageQuery<UserQuery> query) {
        return RespResult.success(userService.query(query));
    }

}
