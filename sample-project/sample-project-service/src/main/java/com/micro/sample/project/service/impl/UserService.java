package com.micro.sample.project.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.data.keyvalue.repository.support.QuerydslKeyValueRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.micro.sample.project.commands.CreateUserCmd;
import com.micro.sample.project.config.DefaultObjectMapper;
import com.micro.sample.project.dto.UserDto;
import com.micro.sample.project.mapStruct.UserMapping;
import com.micro.sample.project.model.QUser;
import com.micro.sample.project.model.User;
import com.micro.sample.project.repository.JpaDslRepository;
import com.micro.sample.project.resp.PageQuery;
import com.micro.sample.project.query.UserQuery;
import com.micro.sample.project.resp.PageUtil;
import com.micro.sample.project.resp.PageVo;
import com.micro.sample.project.service.IUserService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final QuerydslKeyValueRepository<User, Long> repository;

    private final JPAQueryFactory queryFactory;

    private final DefaultObjectMapper objectMapper;

    @Override
    public PageVo<UserDto> query(PageQuery<UserQuery> query) {
        log.info("用户条件查询参数：{}", objectMapper.writeValueAsString(query));
        Predicate predicate = warpCondition(query.getSearch());
        Pageable pageable = PageRequest.of(query.getPage(), query.getPageSize());
        Page<User> all = repository.findAll(predicate, pageable);
        return PageUtil.buildPageVo(all.map(UserMapping.USER_MAPPING::convertUserDoToDto));
    }

    private Predicate warpCondition(UserQuery search) {
        Predicate predicate = new BooleanBuilder();
        if (search == null) return predicate;

        QUser user = QUser.user;
        predicate = search.getIsDelete() == null ? predicate :
                ExpressionUtils.and(predicate, user.isDelete.eq(search.getIsDelete()));
        predicate = StringUtils.isBlank(search.getLoginName()) ? predicate :
                ExpressionUtils.and(predicate, user.loginName.like(search.getLoginName()));
        predicate = StringUtils.isBlank(search.getUsername()) ? predicate :
                ExpressionUtils.and(predicate, user.username.like(search.getUsername()));
        return predicate;
    }

    @Override
    @Transactional
    public Long create(CreateUserCmd cmd) {
        log.info("创建用户命令：{}", objectMapper.writeValueAsString(cmd));
        User user = UserMapping.USER_MAPPING.createCmdToUser(cmd);
        User save = repository.save(user);
        return save.getId();
    }
}
