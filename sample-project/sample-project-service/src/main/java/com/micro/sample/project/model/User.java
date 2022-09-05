package com.micro.sample.project.model;

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

    /**
     * 用户名称
     */
    @Column(name = "username", length = 64, nullable = false)
    private String username;

    /**
     * 登录名称
     */
    @Column(name = "login_name", length = 64, nullable = false, unique = true)
    private String loginName;

    /**
     * 手机号
     */
    @Column(name = "telephone", length = 64, nullable = false)
    private String telephone;

    /**
     * 邮箱
     */
    @Column(name = "email", length = 64, nullable = false)
    private String email;

    /**
     * 密码
     */
    @Column(name = "password", length = 64, nullable = false)
    private String password;

    /**
     * 状态 0：启用 1：禁用
     */
    @Column(name = "status", length = 4, nullable = false)
    private Short status;

    /**
     * 删除标识 0：删除 1：未删除
     */
    @Column(name = "is_delete", length = 2, nullable = false)
    private Boolean isDelete;


}
