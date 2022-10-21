package com.tiankong44.tool.gis.controller;

import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.gis.service.GisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * WGS84坐标系	地球坐标系，国际通用坐标系
 * GCJ02坐标系	火星坐标系，WGS84坐标系加密后的坐标系；Google国内地图、高德、QQ地图 使用
 * BD09坐标系	百度坐标系，GCJ02坐标系加密后的坐标系
 *
 * @author zhanghao_SMEICS
 * @date 2022-10-21 21:45
 */
@RestController("/gis")
public class GisController {
    @Autowired
    GisService gisService;

    /**
     * WGS84坐标系转GCJ02坐标系
     *
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    @RequestMapping("/WGS84ToGCJ02")
    @ResponseBody
    public BaseRes WGS84ToGCJ02(@RequestBody String msg) {
        return gisService.WGS84ToGCJ02(msg);
    }

    /**
     * GCJ02坐标系转WGS84坐标系
     *
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    @ResponseBody
    @RequestMapping("/GCJ02ToWGS84")
    public BaseRes GCJ02ToWGS84(@RequestBody String msg) {
        return gisService.GCJ02ToWGS84(msg);
    }

    /**
     * 获取两点或多个点之间的距离
     *
     * @author zhanghao_SMEICS
     * @date 2022/10/21 22:20
     */
    @ResponseBody
    @RequestMapping("/getDistance")
    public BaseRes getDistance(@RequestBody String msg) {
        return gisService.getDistance(msg);
    }
}
