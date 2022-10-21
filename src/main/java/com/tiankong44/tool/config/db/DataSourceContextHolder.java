package com.tiankong44.tool.config.db;

/**
 * @Description :
 * @Author zhanghao_SMEICS
 * @Date 2022/10/21  14:55
 **/
public class DataSourceContextHolder {
    private DataSourceContextHolder(){}

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSource(String dbType){
        contextHolder.set(dbType);
    }

    public static String getDataSource(){
        return contextHolder.get();
    }

    public static void clearDataSource(){
        contextHolder.remove();
    }
}
