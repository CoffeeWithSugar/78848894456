package com.yweiai.configbean;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 数据源配置
 * @author wj
 */
@Configuration
@PropertySource("classpath:JDBC.properties")
public class DataSourceConfig {
    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.maxActive}")
    private String maxActive;

    @Value("${jdbc.maxIdel}")
    private String maxIdel;

    @Value("${jdbc.maxWait}")
    private String maxWait;

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setMaxActive(Integer.parseInt(maxActive));
        dataSource.setMaxIdle(Integer.parseInt(maxIdel));
        dataSource.setMaxWait(Integer.parseInt(maxWait));
        return dataSource;
    }

}
