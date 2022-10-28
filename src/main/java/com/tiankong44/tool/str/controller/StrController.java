package com.tiankong44.tool.str.controller;

import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.gis.entity.Coordinate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description : 字符串工具
 * @Author zhanghao_SMEICS
 * @Date 2022/10/28  9:05
 **/
@RestController
@RequestMapping("/str")
@Validated
@Tag(name = "地理位置坐标")
public class StrController {



}
