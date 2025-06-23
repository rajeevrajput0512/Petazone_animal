package com.petazone.user.utils;

import com.petazone.user.dto.response.ApiResponseCommon;

public final class ResponseUtils {

    private ResponseUtils() {
        // private constructor to prevent instantiation
    }

    public static <T> ApiResponseCommon<T> createSuccessResponse(T data) {
        return new ApiResponseCommon<T>(true, data, null);
    }

    public static <T> ApiResponseCommon<T> createErrorResponse(String msg) {
        return new ApiResponseCommon<T>(false, null, msg);
    }

    public static <T> ApiResponseCommon<T> createSuccessResponseWithMsg(T data, String msg) {
        return new ApiResponseCommon<T>(true, data, msg);
    }
}
