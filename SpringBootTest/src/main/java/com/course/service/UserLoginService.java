package com.course.service;

import com.course.modle.request.UserInfoDTO;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletResponse;

public interface UserLoginService {

    Boolean login(UserInfoDTO userInfoDTO, HttpServletResponse response);

}
