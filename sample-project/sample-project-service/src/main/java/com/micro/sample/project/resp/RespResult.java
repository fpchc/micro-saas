package com.micro.sample.project.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class RespResult<T> {

    private static final String SUCCESS_CODE = "200";

    private String code;

    private String msg;

    private T data;

    public static <T> RespResult<T> success() {
        return RespResult.of(SUCCESS_CODE, null, null);
    }

    public static <T> RespResult<T> success(String msg) {
        return RespResult.of(SUCCESS_CODE, msg, null);
    }

    public static <T> RespResult<T> success(T data) {
        return RespResult.of(SUCCESS_CODE, null, data);
    }

    public static <T> RespResult<T> success(String msg, T data) {
        return RespResult.of(SUCCESS_CODE, msg, data);
    }

    public static <T> RespResult<T> fail(String code, String msg) {
        return RespResult.of(code, msg, null);
    }

}
