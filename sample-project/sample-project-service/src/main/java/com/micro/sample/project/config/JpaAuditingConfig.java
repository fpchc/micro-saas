package com.micro.sample.project.config;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.jpa.repository.support.QuerydslJpaPredicateExecutor;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.lang.Nullable;

import com.querydsl.core.types.dsl.PathBuilder;

import cn.hutool.core.util.IdUtil;

@Configuration
@EnableJpaAuditing()
public class JpaAuditingConfig<T> {

    @Bean(name = "snowFlakeIdentifierGenerator")
    public IdentifierGenerator identifierGenerator() {
      return new SnowFlakeIdentifierGenerator();
    }

    @Bean
    public AuditorAware<Long> auditorAware() {
        return () -> Optional.of(1000000L);
    }


}
