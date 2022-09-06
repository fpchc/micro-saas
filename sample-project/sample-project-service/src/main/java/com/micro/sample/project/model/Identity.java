package com.micro.sample.project.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.mapstruct.ap.internal.model.GeneratedType;
import org.springframework.data.keyvalue.core.IdentifierGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class Identity {

    @Id
    @GenericGenerator(name = "snowFlakeIdentifierGenerator",
            strategy = "com.micro.sample.project.config.SnowFlakeIdentifierGenerator")
    @GeneratedValue(generator = "snowFlakeIdentifierGenerator")
    @Column(name = "id", length = 11)
    private Long id;

}
