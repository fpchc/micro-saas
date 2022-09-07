package com.micro.sample.project.api.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @Schema(title = "创建人", description = "创建人")
    private String createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM")
    @Schema(title = "创建时间", description = "创建时间")
    private LocalDateTime createdTime;

    @Schema(title = "修改人", description = "修改人")
    private String modifiedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM")
    @Schema(title = "修改时间", description = "修改时间")
    private LocalDateTime modifiedTime;

}
