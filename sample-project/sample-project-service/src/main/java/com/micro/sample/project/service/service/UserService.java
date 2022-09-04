package com.micro.sample.project.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.sample.project.service.model.QUser;
import com.micro.sample.project.service.model.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> queryAll() {
        QUser user = QUser.user;
        return null;
    }


}
