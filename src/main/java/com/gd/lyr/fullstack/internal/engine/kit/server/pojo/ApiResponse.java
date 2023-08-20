package com.gd.lyr.fullstack.internal.engine.kit.server.pojo;

/**
 * @author Yan.Ru.Li
 * @description ApiResponse
 * @date 2023/7/12 22:50:30
 */

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private StatusResponse status;
    private T data;

    @Data
    @AllArgsConstructor
    public static class StatusResponse {
        private int code;
        private String message;
    }

    public static <T> ApiResponse<T> successResponse(T data) {
        StatusResponse statusResponse = new StatusResponse(200, "Success");
        return new ApiResponse<>(statusResponse, data);
    }
}
