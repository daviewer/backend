package com.daou.reviewer.domain.service;

import com.daou.reviewer.common.error.DaReviewerGlobalException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
public class FileConvertManager {

    public String convertFileToString(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            throw new DaReviewerGlobalException("파일을 문자열로 변환하는 중 오류가 발생했습니다.", e);
        }
    }

}
