package com.micro.sample.project.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder(toBuilder = true)
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User extends AuditingModel{

    @Column(name = "login_name", length = 64, unique = true)
    private String loginName;

    @Column(name = "telephone", length = 64)
    private String telephone;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "status")
    private Short status;

    @Column(name = "is_delete", length = 4)
    private Boolean isDelete;


}
