package com.course.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Api(value = "/start")
@RestController
@RequestMapping("/loginController")
public class LoginController {

    @GetMapping("/getCookies")
    @ApiOperation(value = "设置cookie",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login1","true");
        response.addCookie(cookie);
        return "SET COOKIE SUCCESS";
    }

    @GetMapping("/getWithCookies")
    @ApiOperation(value = "获取cookie",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "COOKIE IS NULL";
        }
        for (Cookie cookie : cookies){
            if (Objects.nonNull(cookie)){
                if (cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                    return "GET COOKIE SUCCESS";
                }
            }
        }
        return "COOKIE INFO ERROR";
    }

    @GetMapping("/getSkuList")
    @ApiOperation(value = "获取商品列表",httpMethod = "GET")
    public Map<String,Integer> getSkuList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("鞋子",698);
        stringIntegerMap.put("帽子",198);
        stringIntegerMap.put("裤子",298);
        return stringIntegerMap;
    }

    @RequestMapping(value = "/getList/{start}/{end}")
    @ApiOperation(value = "获取列表",httpMethod = "GET")
    public Map getList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("鞋子",698);
        stringIntegerMap.put("帽子",198);
        stringIntegerMap.put("裤子",298);
        return stringIntegerMap;
    }


    @PostMapping("/getGoodsList")
    @ApiOperation("获取商品列表")
    public Map getGoodsList(HttpServletRequest request, @RequestParam String fff,@RequestParam Integer aaa){
        final Map<String, Integer> stringIntegerMap = new HashMap<>();
        if (Objects.isNull(request.getCookies())){
            stringIntegerMap.put("cookie不存在",400);
            return stringIntegerMap;
        }
        final Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if (!cookie.getName().equals("login")||!cookie.getValue().equals("true")){
                stringIntegerMap.put("cookie信息错误",402);
                return stringIntegerMap;
            }
        }
        stringIntegerMap.put("鞋子",698);
        stringIntegerMap.put("帽子",198);
        stringIntegerMap.put("裤子",298);
        stringIntegerMap.put(fff,aaa);
        return stringIntegerMap;
    }

}
