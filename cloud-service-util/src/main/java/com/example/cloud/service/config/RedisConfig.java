package com.example.cloud.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class RedisConfig {

    //读取配置文件中的redis的ip地址
    @Value("${dev.spring.redis.host:disabled}")
    private String host;

    //读取配置文件中的redis的端口号
    @Value("${dev.spring.redis.port:0}")
    private int port;

    //Redis数据库索引（默认为0）
    @Value("${dev.spring.redis.database:0}")
    private int database;

    //Redis数据库索引（默认为0）
    @Value("${dev.spring.redis.password}")
    private String password;

    //设置最大实例总数
    @Value("${dev.spring.redis.pool.max-active:1000}")
    private int maxTotal;

    //maxIdle,最大空闲数,数据库连接的最大空闲时间。
    // 超过空闲时间,数据库连 接将被标记为不可用,然后被释放。
    // 设为0表示无限制
    @Value("${dev.spring.redis.pool.max-idle:1000}")
    private int maxIdle;

    @Value("${dev.spring.redis.pool.min-idle:1000}")
    private int minIdle;

    @Value("${dev.spring.redis.timeout:10000}")
    private int timeout;

    //连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
    private boolean blockWhenExhausted = true;

    //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),
    // 如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
    @Value("${dev.spring.redis.pool.max-wait:1000}")
    private int maxWaitMillis;

    //在获取连接的时候检查有效性, 默认false
    private boolean testOnBorrow = true;

    //在空闲时检查有效性, 默认false
    private boolean testWhileIdle = true;

    private boolean testOnReturn = true;

    ////表示idle object evitor两次扫描之间要sleep的毫秒数
    //@Value("${dev.spring.redis.pool.max-wait:10000}")
    //private int timeBetweenEvictionRunsMillis;
    //
    ////表示idle object evitor每次扫描的最多的对象数
    //@Value("${dev.spring.redis.pool.max-wait:20}")
    //private int numTestsPerEvictionRun;
    //
    ////表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；
    //// 这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
    //@Value("${dev.spring.redis.pool.max-wait:60000}")
    //private int minEvictableIdleTimeMillis;

    public String getHost() {
        return this.host;
    }

    public void setHost(final String host) {
        this.host = host;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(final int port) {
        this.port = port;
    }

    public int getDatabase() {
        return this.database;
    }

    public void setDatabase(final int database) {
        this.database = database;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public int getMaxTotal() {
        return this.maxTotal;
    }

    public void setMaxTotal(final int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return this.maxIdle;
    }

    public void setMaxIdle(final int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return this.minIdle;
    }

    public void setMinIdle(final int minIdle) {
        this.minIdle = minIdle;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(final int timeout) {
        this.timeout = timeout;
    }

    public boolean isBlockWhenExhausted() {
        return this.blockWhenExhausted;
    }

    public void setBlockWhenExhausted(final boolean blockWhenExhausted) {
        this.blockWhenExhausted = blockWhenExhausted;
    }

    public int getMaxWaitMillis() {
        return this.maxWaitMillis;
    }

    public void setMaxWaitMillis(final int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public boolean isTestOnBorrow() {
        return this.testOnBorrow;
    }

    public void setTestOnBorrow(final boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestWhileIdle() {
        return this.testWhileIdle;
    }

    public void setTestWhileIdle(final boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public boolean isTestOnReturn() {
        return this.testOnReturn;
    }

    public void setTestOnReturn(final boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }
}
