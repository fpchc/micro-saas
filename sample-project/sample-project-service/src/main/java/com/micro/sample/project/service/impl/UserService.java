package com.micro.sample.project.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.micro.sample.project.config.DefaultObjectMapper;
import com.micro.sample.project.dto.UserDto;
import com.micro.sample.project.mapStruct.UserMapping;
import com.micro.sample.project.model.QUser;
import com.micro.sample.project.model.User;
import com.micro.sample.project.query.PageQuery;
import com.micro.sample.project.query.UserQuery;
import com.micro.sample.project.service.AbstractService;
import com.micro.sample.project.service.IUserService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService extends AbstractService<User, Long> implements IUserService {

    private final DefaultObjectMapper objectMapper;

    @Override
    public Page<UserDto> query(PageQuery<UserQuery> query) {
        log.info("用户条件查询参数：{}", objectMapper.writeValueAsString(query));
        Predicate predicate = warpCondition(query.getSearch());
        Pageable pageable = PageRequest.of(query.getPage(), query.getPageSize());
        Page<User> all = repository.findAll(predicate, pageable);
        return all.map(UserMapping.USER_MAPPING::convertUserDoToDto);
    }

    private Predicate warpCondition(UserQuery search) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (search == null) return booleanBuilder;

        QUser user = QUser.user;

        return null;
    }
}
