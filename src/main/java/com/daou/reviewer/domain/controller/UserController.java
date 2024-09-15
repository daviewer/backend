package com.daou.reviewer.domain.controller;

import com.daou.reviewer.domain.dto.AIUploadDiffResponse;
import com.daou.reviewer.domain.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class UserController {

    @PostMapping("/user/join")
    public ApiResponse<String> joinUser(){
        return AIUploadDiffResponse.success("");
    }

    @PostMapping("/user/login")
    public ApiResponse<String> loginUser(){
        return AIUploadDiffResponse.success("");
    }

    @PostMapping("/project/save")
    public ApiResponse<String> saveProjectInfo(){
        return AIUploadDiffResponse.success("");
    }

    @GetMapping("/project/findAllById")
    public ApiResponse<String> findAllProjectInfo(){
        return AIUploadDiffResponse.success("");
    }

    @GetMapping("/project/findById")
    public ApiResponse<String> findProjectInfo(){
        return AIUploadDiffResponse.success("");
    }

    @PostMapping("/project/delete")
    public ApiResponse<String> deleteProjectInfo(){
        return AIUploadDiffResponse.success("");
    }
}
