package com.tiankong44.tool.gis.entity;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "坐标")
public class Coordinate {
    /**
     * 经度
     */
    @NotNull(message = "经度不能为空")
    @Max(180)
    @Min(0)
    @Schema(name = "longitude", description = "经度")
    private double longitude;
    /**
     * 纬度
     */
    @Max(90)
    @Min(0)
    @NotNull(message = "纬度不能为空")
    @Schema(name = "latitude", description = "纬度")
    private double latitude;
    /**
     * 海拔
     */
    @Schema(name = "elevation", description = "海拔")
    private double elevation;
    /**
     * 坐标系类型
     */
    @NotNull(message = "坐标系类型不能为空")
    @Max(2)
    @Min(0)
    @Schema(name = "coordinateType", description = "坐标系类型")
    //private Integer coordinateType=CoordinateTypeEnum.GCJ02.value;
    private Integer coordinateType=CoordinateTypeEnum.GCJ02.value;
}
