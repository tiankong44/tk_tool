package com.tiankong44.tool.str.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Description :
 * @Author zhanghao_SMEICS
 * @Date 2022/10/28  9:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "字符串分割")
public class SplitVo {
    /**
     * 被分割的字符串
     */
    @NotNull(message = "字符串不能为空")
    @Schema(name = "str", description = "字符串")
    private String str;

    /**
     * 分割符
     */
    @NotNull(message = "分割符不能为空")
    @Schema(name = "split", description = "分割符")
    private String split;
}
