package com.micro.sample.project.service;

import com.micro.sample.project.api.commands.CreateUserCmd;
import com.micro.sample.project.api.dto.UserDto;
import com.micro.sample.project.resp.PageQuery;
import com.micro.sample.project.api.query.UserQuery;
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
