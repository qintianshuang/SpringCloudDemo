package com.example.cloud.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.LinkedList;
import java.util.List;

@Service
public class RedisPoolFactory {

    @Autowired
    RedisConfig redisConfig;

    /**
     * redis连接池的一些配置
     * 基于ShardedJedisPool
     * @return
     */
    @Bean
    public ShardedJedisPool ShardedJedisPoolFactory(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisConfig.getMaxTotal());
        poolConfig.setMaxIdle(redisConfig.getMaxIdle());
        poolConfig.setMinIdle(redisConfig.getMinIdle());
        poolConfig.setBlockWhenExhausted(redisConfig.isBlockWhenExhausted());
        poolConfig.setMaxWaitMillis(redisConfig.getMaxWaitMillis());

        poolConfig.setTestOnBorrow(redisConfig.isTestOnBorrow());

        poolConfig.setTestOnReturn(redisConfig.isTestOnReturn());
        //Idle时进行连接扫描
        poolConfig.setTestWhileIdle(redisConfig.isTestWhileIdle());
        //// 集群
        JedisShardInfo jedisShardInfo = new JedisShardInfo(redisConfig.getHost(), redisConfig.getPort());
        //jedisShardInfo.setPassword(redisConfig.getPassword());
        List<JedisShardInfo> jedisShardInfos = new LinkedList<JedisShardInfo>();
        jedisShardInfos.add(jedisShardInfo);
        ShardedJedisPool jedisPool = new ShardedJedisPool(poolConfig, jedisShardInfos);

        //JedisPool jedisPool = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout(), redisConfig.getPassword());

        return jedisPool;
    }


    /**
     * redis连接池的一些配置
     * 基于JedisPool
     * @return
     */
    @Bean
    public JedisPool JedisPoolFactory(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisConfig.getMaxTotal());
        poolConfig.setMaxIdle(redisConfig.getMaxIdle());
        poolConfig.setMinIdle(redisConfig.getMinIdle());
        poolConfig.setBlockWhenExhausted(redisConfig.isBlockWhenExhausted());
        poolConfig.setMaxWaitMillis(redisConfig.getMaxWaitMillis());

        poolConfig.setTestOnBorrow(redisConfig.isTestOnBorrow());

        poolConfig.setTestOnReturn(redisConfig.isTestOnReturn());
        //Idle时进行连接扫描
        poolConfig.setTestWhileIdle(redisConfig.isTestWhileIdle());

        JedisPool jedisPool = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout());

        return jedisPool;
    }
}
