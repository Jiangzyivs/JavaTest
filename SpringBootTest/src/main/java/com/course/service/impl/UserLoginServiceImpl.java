package com.course.service.impl;

import com.course.modle.request.UserInfoDTO;
import com.course.service.UserLoginService;
import com.course.util.jzyutil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {

    /**
     * 登录并向前端返回cookie
     * @param userInfoDTO
     * @return
     */
    @Override
    public Boolean login(UserInfoDTO userInfoDTO, HttpServletResponse response) {
        boolean flag;
        if (Objects.isNull(userInfoDTO)){
            flag = false;
            return flag;
        }
        if (userInfoDTO.getName().equals("jzy") && userInfoDTO.getPassword().equals("123456")){
            flag = true;
            log.info(userInfoDTO.getPassword());
            String pswd = jzyutil.encryptToMD5(userInfoDTO.getPassword());
            log.info(pswd);
            String loginHeader = userInfoDTO.getName()+ pswd;
            Cookie cookie = new Cookie("loginHeader", loginHeader);
            response.addCookie(cookie);
        }else {
            flag = false;
        }
        return flag;
    }

}
