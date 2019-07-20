package com.example.cloud.service.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Component
@Configuration
@EnableConfigurationProperties(value = MybatisProperties.class)
@MapperScan(basePackages = {"com.example.cloud"})
public class MybatisConfig {

    @Autowired
    private MyDbProperties myDbProperties;

    //@Autowired
    //@Qualifier("mysqlDataSource")
    //private DataSource mysqlDataSource;
    //
    //@Autowired
    //@Qualifier("oracleDataSource")
    //private DataSource oracleDataSource;

    @Bean
    public PlatformTransactionManager DataTransaction(@Qualifier("localhostDataSource") DataSource localhostDataSource) {
        return new DataSourceTransactionManager(localhostDataSource);
    }

    @Bean(destroyMethod = "close")
    @ConditionalOnMissingBean(name = "localhostDataSource")
    public DataSource localhostDataSource() {
        Properties properties = new Properties();
        properties.put("driverClass", "com.mysql.jdbc.Driver");
        properties.put("url", myDbProperties.getUrl());
        properties.put("username", myDbProperties.getUsername());
        properties.put("password", myDbProperties.getPassword());
        try {
            return DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean(name ={"localhostSqlSessionFactory"})
    public SqlSessionFactory localhostSqlSessionFactory(@Qualifier("localhostDataSource") DataSource localhostDataSource)
            throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(localhostDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis/config/mybatis-config.xml"));
        sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
        return sqlSessionFactory.getObject();
    }
}
