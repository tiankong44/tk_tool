package com.tiankong44.tool.gis.service.impl;

import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.gis.entity.Coordinate;
import com.tiankong44.tool.gis.service.GisService;
import com.tiankong44.tool.util.GisUtil;
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
     * @param coordinate
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    @Override
    public BaseRes WGS84ToGCJ02(Coordinate coordinate) {
        double[] doubles = GisUtil.toGCJ02Point(coordinate.getLatitude(), coordinate.getLongitude());
        coordinate.setLatitude(doubles[0]);
        coordinate.setLongitude(doubles[1]);
        return BaseRes.success(coordinate);
    }

    /**
     * 获取两点或多个点之间的距离
     *
     * @param coordinate
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    @Override
    public BaseRes GCJ02ToWGS84(Coordinate coordinate) {
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
}
