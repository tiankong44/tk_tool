package com.tiankong44.tool.gis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhanghao_SMEICS
 * @date 2022-10-21 22:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate {
    /**
     * 经度
     */
    private double longitude;
    /**
     * 纬度
     */
    private double latitude;
    /**
     * 海拔
     */
    private double elevation;
}
