package com.tiankong44.tool.gis.service;

import com.tiankong44.tool.base.entity.BaseRes;

public interface GisService {
    /**
     * WGS84坐标系转GCJ02坐标系
     *
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    BaseRes WGS84ToGCJ02(String msg);


    /**
     * GCJ02坐标系转WGS84坐标系
     *
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    BaseRes getDistance(String msg);

    /**
     * 获取两点或多个点之间的距离
     *
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    BaseRes GCJ02ToWGS84(String msg);
}
