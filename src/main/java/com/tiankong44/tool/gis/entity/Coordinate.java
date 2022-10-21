package com.tiankong44.tool.gis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
    @NotNull(message = "经度 不能为空")
    @Max(180)
    @Min(0)
    private double longitude;
    /**
     * 纬度
     */
    @Max(90)
    @Min(0)
    private double latitude;
    /**
     * 海拔
     */
    private double elevation;
}
