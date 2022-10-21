package com.tiankong44.tool.config.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**


 * @Description :
 * @Author zhanghao_SMEICS
 * @Date 2022/10/21  14:54
 **/
public class DynamicDataSource  extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
