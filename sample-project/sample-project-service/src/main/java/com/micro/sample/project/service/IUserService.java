package com.micro.sample.project.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.micro.sample.project.dto.UserDto;
import com.micro.sample.project.model.User;
import com.micro.sample.project.query.PageQuery;
import com.micro.sample.project.query.UserQuery;

public interface IUserService {

    Page<UserDto> query(PageQuery<UserQuery> query);

}
