package com.course.controller;


import com.course.dao.AreaDao;
import com.course.modle.po.Areapo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@Api(value = "/start")
@RestController
@RequestMapping("/loginController")
public class AreaController {

    @Resource
    private AreaDao areaDao;

    @GetMapping("/getAreaList")
    @ApiOperation(value = "查询区域",httpMethod = "GET")
    public List<Areapo> getAreaList(){
        List<Areapo> areapos = areaDao.queryArea();
        return areapos;
    }

}
