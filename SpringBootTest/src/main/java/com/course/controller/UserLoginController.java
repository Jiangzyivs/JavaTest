package com.course.controller;

import com.course.api.UserLoginApi;
import com.course.modle.request.UserInfoDTO;
import com.course.service.UserLoginService;
import com.course.util.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/user")
@RestController
@Api(description = "用户",value = "/userLoginController")
public class UserLoginController implements UserLoginApi {


    @Resource
    private UserLoginService userLoginService;

    @Override
    @GetMapping("/test")
    public ApiResult<Boolean> test() {
        return ApiResult.success(true);
    }

    @Override
    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ApiResult<Boolean> login(@Validated @RequestBody UserInfoDTO userInfoDTO,HttpServletResponse response) {
        return ApiResult.success(userLoginService.login(userInfoDTO, response));
    }




}
