package com.micro.sample.project.service;

import org.springframework.data.domain.Page;

import com.micro.sample.project.commands.CreateUserCmd;
import com.micro.sample.project.dto.UserDto;
import com.micro.sample.project.resp.PageQuery;
import com.micro.sample.project.query.UserQuery;
import com.micro.sample.project.resp.PageVo;

public interface IUserService {

    /**
     * 用户条件查询
     *
     * @param query
     * @return
     */
    PageVo<UserDto> query(PageQuery<UserQuery> query);

    /**
     * 创建用户命令
     *
     * @param cmd
     * @return
     */
    Long create(CreateUserCmd cmd);
}
