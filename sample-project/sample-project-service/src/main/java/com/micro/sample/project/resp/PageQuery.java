package com.micro.sample.project.resp;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.google.common.collect.Lists;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(staticName = "of")
public class PageQuery<T> {

    @Schema(description = "page")
    @Builder.Default
    private Integer page = 0;

    @Schema(description = "pageSize")
    @Builder.Default
    private Integer pageSize = 10;

    @Schema(description = "asc:正序 desc:倒序")
    @Builder.Default
    private String direction = "asc";

    @Schema(description = "排序字段")
    @Builder.Default
    private String orderBy = "createdAt";

    private T search;


}
