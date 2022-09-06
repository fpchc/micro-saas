package com.micro.sample.project.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.micro.sample.project.model.User;
import com.micro.sample.project.repository.JpaDslRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

public abstract class AbstractService<T, ID> {

    @Autowired(required = false)
    protected JpaDslRepository<T, ID> repository;

    @Autowired(required = false)
    protected JPAQueryFactory queryFactory;

}
