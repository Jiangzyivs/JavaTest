package com.course.api;

import com.course.modle.request.UserInfoDTO;
import com.course.util.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;


public interface UserLoginApi {


    @GetMapping("/test")
    ApiResult<Boolean> test();

    @PostMapping("/login")
    ApiResult<Boolean> login(@RequestBody UserInfoDTO userInfoDTO, HttpServletResponse response);



}
