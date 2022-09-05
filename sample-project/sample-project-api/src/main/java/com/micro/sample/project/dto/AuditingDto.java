package com.micro.sample.project.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AuditingDto {

    @Schema(name = "创建人")
    private String createdAt;

    private LocalDateTime createdTime;

    private String modifiedAt;

    private LocalDateTime modifiedTime;

}
