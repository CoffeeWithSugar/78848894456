package com.yweiai.configbean;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis mapper 扫描配置
 * @author wj
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)  //mybatic配置初始化完成后，再初始化
public class MyBatisMapperScanConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactor");
        //mapper扫描路径
        mapperScannerConfigurer.setBasePackage("com.yweiai.mapper");
        return mapperScannerConfigurer;
    }
}
