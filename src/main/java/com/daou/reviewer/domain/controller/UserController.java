package com.daou.reviewer.domain.controller;

import com.daou.reviewer.domain.dto.AIUploadDiffResponse;
import com.daou.reviewer.domain.dto.ApiResponse;
import com.daou.reviewer.domain.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public ApiResponse<Boolean> loginUser(@RequestBody LoginRequest request){
        if("kingmj".equals(request.userId()) || "jhpark".equals(request.userId())){
            return AIUploadDiffResponse.success("");
        }
        return AIUploadDiffResponse.fail(401);
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
