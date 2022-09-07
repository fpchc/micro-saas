package com.micro.sample.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.micro.sample.project.model.User;

public interface UserRepository extends JpaDslRepository<User, Long>{

}
