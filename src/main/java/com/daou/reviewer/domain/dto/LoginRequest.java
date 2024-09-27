package com.daou.reviewer.domain.dto;

/**
 * @author : kingmj
 * @description : login request
 * @packageName : com.daou.reviewer.domain.dto
 * @fileName : LoginRequest
 * @date : 2024. 9. 27.
 */
public record LoginRequest(
        String userId,
        String password
) {
}
