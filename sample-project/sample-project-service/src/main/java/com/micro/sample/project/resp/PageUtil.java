package com.micro.sample.project.resp;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class PageUtil {

    public static<T> PageRequest buildPage(PageQuery<T> pageQuery) {
        Direction asc = StringUtils.equals(pageQuery.getDirection(), "asc") ? Direction.ASC : Direction.DESC;
        Sort sort = Sort.by(asc, pageQuery.getOrderBy());
        return PageRequest.of(pageQuery.getPage(), pageQuery.getPageSize(), sort);
    }

    public static <T> PageVo<T> buildPageVo(Slice<T> slice) {
        final Long finalTotal = 0L;
        Long total = slice.getPageable().toOptional()
                .filter(it -> !slice.getContent().isEmpty())//
                .filter(it -> it.getOffset() + it.getPageSize() > finalTotal)//
                .map(it -> it.getOffset() + slice.getContent().size())//
                .orElse(finalTotal);
        return PageVo.of(slice.getNumber(), slice.getSize(), total, slice.getContent());
    }

}
