package com.micro.sample.project.resp;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class PageVo<T> {

    private Integer page;

    private Integer pageSize;

    private Long total;

    private List<T> data;

}
