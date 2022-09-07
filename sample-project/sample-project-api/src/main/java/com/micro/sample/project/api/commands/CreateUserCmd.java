package com.micro.sample.project.api.commands;

import java.rmi.dgc.Lease;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Schema(title = "创建用户模型")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserCmd {

    @Schema(title = "用户名称")
    @NotBlank(message = "用户名称不能未空")
    private String username;

    /**
     * 登录名称
     */
    @NotBlank(message = "登录名称不能未空")
    @Schema(title = "登录名称")
    private String loginName;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能未空")
    @Schema(title = "手机号")
    private String telephone;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能未空")
    @Schema(title = "邮箱")
    private String email;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能未空")
    @Schema(title = "密码")
    private String password;


}
