package com.daou.reviewer.domain.dto;

public interface ApiResponse<T> {
    int getCode();
    String getMessage();
    T getBody();
}
