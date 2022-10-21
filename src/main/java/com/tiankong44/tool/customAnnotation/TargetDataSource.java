package com.tiankong44.tool.customAnnotation;

import com.tiankong44.tool.config.db.EnumDataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description :
 * @Author zhanghao_SMEICS
 * @Date 2022/10/21  15:13
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {
    EnumDataSourceType value() default EnumDataSourceType.MASTER;
}
