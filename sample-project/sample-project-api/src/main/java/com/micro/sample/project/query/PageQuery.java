package com.micro.sample.project.query;

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

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer pageSize = 10;

    private T search;

}
