package com.tiankong44.tool.gis.service.impl;

import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.gis.service.GisService;
import org.springframework.stereotype.Service;

/**
 * @author zhanghao_SMEICS
 * @date 2022-10-21 21:46
 */
@Service
public class GisServiceImpl implements GisService {


    /**
     * WGS84坐标系转GCJ02坐标系
     *
     * @param msg
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    @Override
    public BaseRes WGS84ToGCJ02(String msg) {
        return null;
    }

    /**
     * GCJ02坐标系转WGS84坐标系
     *
     * @param msg
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    @Override
    public BaseRes getDistance(String msg) {
        return null;
    }

    /**
     * 获取两点或多个点之间的距离
     *
     * @param msg
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    @Override
    public BaseRes GCJ02ToWGS84(String msg) {
        return null;
    }
}
