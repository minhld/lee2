package com.minh.lee2.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private Integer code;
    private String error;
    private String message;
}
