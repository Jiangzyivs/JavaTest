package com.course.dao;


import com.course.modle.po.Areapo;

import java.util.List;


public interface AreaDao {

    List<Areapo> queryArea();

    Areapo queryAreaById(int areaId);

    int insertArea(Areapo area);

    int updateArea(Areapo area);

    int deleteArea(int areaId);

}
