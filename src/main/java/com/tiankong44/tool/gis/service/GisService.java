package com.tiankong44.tool.gis.service;

import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.gis.entity.Coordinate;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface GisService {
    /**
     * WGS84坐标系转GCJ02坐标系
     *
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    BaseRes WGS84ToGCJ02(Coordinate coordinate);



    /**
     * 获取两点或多个点之间的距离
     *
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    BaseRes GCJ02ToWGS84(Coordinate coordinate);
    /**
     * GCJ02坐标系转WGS84坐标系
     *
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    BaseRes getDistance(String msg);

}
