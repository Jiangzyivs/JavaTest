package com.jzy.controller;

import com.jzy.model.UserInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@Api(value = "/queryUserCount",description = "Demo")
@RequestMapping("/user")
public class Demo {

    @Resource
    private SqlSessionTemplate template;

    @GetMapping("/getUserCount")
    @ApiModelProperty(value = "获取用户数量")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }

    @PostMapping("/addUser")
    public int addUser(@RequestBody UserInfoVO userInfoVO){
        return template.insert("addUser",userInfoVO);
    }


}
