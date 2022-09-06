package com.micro.sample.project.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@MappedSuperclass
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners({ AuditingEntityListener.class })
public abstract class AuditingModel extends Identity{

    @Version
    private Integer version;

    @CreatedBy
    @Column(length = 11, name = "created_at")
    private Long createdAt;

    @LastModifiedDate
    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @LastModifiedBy
    @Column(name = "modified_at")
    private Long modifiedAt;

    @LastModifiedDate
    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

}
