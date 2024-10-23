package com.course.util;

import lombok.Data;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;


public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean success;
    private String code;
    private String msg;
    private String traceId;
    private T data;

    public ApiResult() {
    }

    public static <T> ApiResult<T> success() {
        ApiResult<T> apiResult = new ApiResult();
        apiResult.setSuccess(true);
        return apiResult;
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> response = success();
        response.setData(data);
        return response;
    }

    public static <T, R extends PageResponse<T>> ApiResult<R> successPage(List<T> data) {
        ApiResult<R> response = success();
        if (data instanceof PageList) {
            response.setData((R) new PageResponse((PageList)data));
        }

        return response;
    }

    public static <T> ApiResult<T> error(String code, String message, Object... params) {
        ApiResult<T> apiResult = new ApiResult();
        apiResult.setSuccess(false);
        return apiResult;
    }


    public static <T> ApiResult<T> error(ApiErrorCode error, Object... params) {
        return error(error.getCode(), error.getMsg(), params);
    }

    public static <T> ApiResult<T> error(String message, ApiErrorCode error, Object... params) {
        return error(error.getCode(), message, params);
    }

    @Transient
    public Boolean isOk() {
        return this.success;
    }

    @Transient
    public Boolean isNotOk() {
        return !this.isOk();
    }

    @Transient
    public Boolean isSucceed() {
        return this.success && this.data != null;
    }

    @Transient
    public Boolean isNotSucceed() {
        return !this.isSucceed();
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public T getData() {
        return this.data;
    }

    public ApiResult<T> setSuccess(final Boolean success) {
        this.success = success;
        return this;
    }

    public ApiResult<T> setCode(final String code) {
        this.code = code;
        return this;
    }

    public ApiResult<T> setMsg(final String msg) {
        this.msg = msg;
        return this;
    }

    public ApiResult<T> setTraceId(final String traceId) {
        this.traceId = traceId;
        return this;
    }

    public ApiResult<T> setData(final T data) {
        this.data = data;
        return this;
    }
}
