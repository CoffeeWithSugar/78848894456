package com.yweiai.configbean;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.util.Properties;

/**
 * mybatis配置类
 * @author wj
 */
@Configuration
@EnableTransactionManagement  //使用这个注解获得事务支持
public class MyBatisConfig implements TransactionManagementConfigurer {
    @Autowired
    private BasicDataSource dataSource;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(){
        SqlSessionFactoryBean sqlSessionFactory=new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        try {
            return sqlSessionFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("sqlSessionFactory 初始化失败");
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    //@Bean
    //public PageHelper pageHelper(){
    //    PageHelper pageHelper=new PageHelper();
    //    Properties properties=new Properties();
    //    properties.setProperty("reasonable", "true");
    //    properties.setProperty("supportMethodsArguments", "true");
    //    properties.setProperty("returnPageInfo", "check");
    //    properties.setProperty("params", "count=countSql");
    //    properties.setProperty("dialect","mysql");
    //    pageHelper.setProperties(properties);
    //    //添加插件
    //    new SqlSessionFactoryBean().setPlugins(new Interceptor[]{new PageInterceptor()});
    //    return pageHelper;
    //}
}
