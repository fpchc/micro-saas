package com.micro.sample.project.config;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.data.util.TypeInformation;

import cn.hutool.core.util.IdUtil;

public class SnowFlakeIdentifierGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return IdUtil.getSnowflake().nextId();
    }
}
