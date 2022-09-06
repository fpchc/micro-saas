package com.micro.sample.project.config;

import java.util.Optional;

import org.hibernate.id.IdentifierGenerator;
import org.redisson.Redisson;
import org.redisson.spring.starter.RedissonProperties;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.core.RedisOperations;


@Configuration
@EnableJpaAuditing()
@EnableCaching
@ConditionalOnClass({Redisson.class, RedisOperations.class})
@AutoConfigureBefore(RedisAutoConfiguration.class)
@EnableConfigurationProperties({RedissonProperties.class, RedisProperties.class})
@ConditionalOnProperty(name = "spring.redis.redisson.enabled", matchIfMissing = true)
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
