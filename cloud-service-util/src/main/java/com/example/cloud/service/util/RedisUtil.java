package com.example.cloud.service.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
//import org.apache.log4j.Logger;
import com.example.cloud.service.config.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedisPool;

@Component("RedisUtil")
public class RedisUtil {

    private final static Logger log = Logger.getLogger(RedisUtil.class);

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    @Autowired
    private JedisPool jedisPool;


    public final static String DATA_REDIS_KEY = "";

    /**
     * redis过期时间,以秒为单位
     */
    public final static int EXRP_HOUR = 60 * 60;            //一小时
    public final static int EXRP_HALF_DAY = 60 * 60 * 12;        //半天
    public final static int EXRP_DAY = 60 * 60 * 24;        //一天
    public final static int EXRP_MONTH = 60 * 60 * 24 * 30; //一个月


    //public ShardedJedis getShardedJedis() {
    //    ShardedJedis jedis = null;
    //    try {
    //        jedis = shardedJedisPool.getResource();
    //    } catch (Exception e) {
    //        System.out.println("redis连接不上");
    //    }
    //    return jedis;
    //}
    //
    //public Jedis getJedis() {
    //    Jedis jedis = null;
    //    try {
    //        jedis = jedisPool.getResource();
    //    } catch (Exception e) {
    //        System.out.println("redis连接不上");
    //    }
    //    return jedis;
    //}


    /**
     *
     * setVExpire(设置key值，同时设置失效时间 秒)
     * @Title: setVExpire
     * @param @param key
     * @param @param value
     * @param @param seconds
     * @param index 具体数据库 默认使用0号库
     * @return void
     * @throws
     */
    public  <V> void setValueExpire(String key, V value,int seconds,int index) {
        String json = JSONObject.toJSONString(value);
        //String json = JSON.toJSONString(value);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(index);
            jedis.set(DATA_REDIS_KEY +key, json);
            jedis.expire(DATA_REDIS_KEY +key, seconds);
        } catch (Exception e) {
            log.error("setV初始化jedis异常：" + e);
            if (jedis != null) {
                //jedisPool.returnBrokenResource(jedis);
                jedis.close();
            }
        } finally {
            closeJedis(jedis);
        }

    }
    /**
     *
     * (存入redis数据)
     * @Title: setV
     * @param @param key
     * @param @param value
//     * @param index 具体数据库
     * @return void
     * @throws
     */
    public  <V> void setValue(String key, V value) {
        String json = JSON.toJSONString(value);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //jedis.select(index);
            jedis.set(key, json);
        } catch (Exception e) {
            log.error("setV初始化jedis异常：" + e);
            if (jedis != null) {
                //jedisPool.returnBrokenResource(jedis);
                jedis.close();
            }
        } finally {
            closeJedis(jedis);
        }

    }

    ///**
    // *
    // * getV(获取redis数据信息)
    // * @Title: getV
    // * @param @param key
    // * @param index 具体数据库 0:常用数据存储      3：session数据存储
    // * @param @return
    // * @return V
    // * @throws
    // */
    //@SuppressWarnings("unchecked")
    //public  <V> V getValue(String key,int index) {
    //    String value = "";
    //    Jedis jedis = null;
    //    try {
    //        jedis = jedisPool.getResource();
    //        jedis.select(index);
    //        value = jedis.get(key);
    //    } catch (Exception e) {
    //        log.error("getV初始化jedis异常：" + e);
    //        if (jedis != null) {
    //            //jedisPool.returnBrokenResource(jedis);
    //            jedis.close();
    //        }
    //    } finally {
    //        closeJedis(jedis);
    //    }
    //    return (V) JSONObject.parse(value);
    //}
    //


    /**
     *
     * getV(获取redis数据信息)
     * @Title: getV
     * @param @param key
     //* @param index 具体数据库 0:常用数据存储      3：session数据存储
     * @param @return
     * @return V
     * @throws
     */
    @SuppressWarnings("unchecked")
    public  <V> V getValue(String key) {
        String value = "";
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            log.error("getV初始化jedis异常：" + e);
            if (jedis != null) {
                //jedisPool.returnBrokenResource(jedis);
                jedis.close();
            }
        } finally {
            closeJedis(jedis);
        }
        //Object parse = JSONObject.parse(value);
        //System.out.println(parse);
        try {
           JSONObject.parse(value);
            return (V) JSONObject.parse(value);
        }catch (JSONException e){
             return (V) value;
        }
    }



    /**
     *
     * getVString(返回json字符串)
     * @Title: getVString
     * @param @param key
     * @param @param index
     * @param @return
     * @return String
     * @throws
     */
    public  String getValueStr(String key,int index) {
        String value = "";
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(index);
            value = jedis.get(DATA_REDIS_KEY +key);
        } catch (Exception e) {
            log.error("getVString初始化jedis异常：" + e);
            if (jedis != null) {
                //jedisPool.returnBrokenResource(jedis);
                jedis.close();
            }
        } finally {
            closeJedis(jedis);
        }
        return value;
    }

    /**
     *
     * Push(存入 数据到队列中)
     *
     * @Title: Push
     * @param @param key
     * @param @param value
     * @return void
     * @throws
     */
    public  <V> void pushValue(String key, V value) {
        String json = JSON.toJSONString(value);
        Jedis jedis = null;
        try {
            log.info("存入 数据到队列中");
            jedis = jedisPool.getResource();
            jedis.select(15);
            jedis.lpush(key, json);
        } catch (Exception e) {
            log.error("Push初始化jedis异常：" + e);
            if (jedis != null) {
                //jedisPool.returnBrokenResource(jedis);
                jedis.close();
            }
        } finally {
            closeJedis(jedis);
        }
    }
    /**
     *
     * Push(存入 数据到队列中)
     *
     * @Title: PushV
     * @param  key
     * @param value
     * @param dBNum
     * @return void
     * @throws
     */
    public  <V> void pushValue(String key, V value,int dBNum) {
        String json = JSON.toJSONString(value);
        Jedis jedis = null;
        try {
            log.info("存入 数据到队列中");
            jedis = jedisPool.getResource();
            jedis.select(dBNum);
            jedis.lpush(key, json);
        } catch (Exception e) {
            log.error("Push初始化jedis异常：" + e);
            if (jedis != null) {
                //jedisPool.returnBrokenResource(jedis);
                jedis.close();
            }
        } finally {
            closeJedis(jedis);
        }
    }

    /**
     *
     * Push(存入 数据到队列中)
     *
     * @Title: Push
     * @param @param key
     * @param @param value
     * @return void
     * @throws
     */
    public  <V> void pushEmail(String key, V value) {

        String json = JSONObject.toJSONString(value);
        Jedis jedis = null;
        try {
            log.info("存入 数据到队列中");
            jedis = jedisPool.getResource();
            jedis.select(15);
            jedis.lpush(key, json);
        } catch (Exception e) {
            log.error("Push初始化jedis异常：" + e);
            if (jedis != null) {
                //jedisPool.returnBrokenResource(jedis);
                jedis.close();
            }
        } finally {
            closeJedis(jedis);
        }
    }

    /**
     *
     * Pop(从队列中取值)
     *
     * @Title: Pop
     * @param @param key
     * @param @return
     * @return V
     * @throws
     */
    @SuppressWarnings("unchecked")
    public  <V> V popValue(String key) {
        String value = "";
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(15);
            value = jedis.rpop(DATA_REDIS_KEY +key);
        } catch (Exception e) {
            log.error("Pop初始化jedis异常：" + e);
            if (jedis != null) {
                //jedisPool.returnBrokenResource(jedis);
                jedis.close();
            }
        } finally {
            closeJedis(jedis);
        }
        return (V) value;
    }


    /**
     *
     * expireKey(限时存入redis服务器)
     *
     * @Title: expireKey
     * @param @param key
     * @param @param seconds
     * @return void
     * @throws
     */
    public  void expireKey(String key, int seconds) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(3);
            jedis.expire(DATA_REDIS_KEY +key, seconds);
        } catch (Exception e) {
            log.error("Pop初始化jedis异常：" + e);
            if (jedis != null) {
                //jedisPool.returnBrokenResource(jedis);
                jedis.close();
            }
        } finally {
            closeJedis(jedis);
        }

    }

    /**
     *
     * closeJedis(释放redis资源)
     *
     * @Title: closeJedis
     * @param @param jedis
     * @return void
     * @throws
     */
    public  void closeJedis(Jedis jedis) {
        try {
            if (jedis != null) {
                /*jedisPool.returnBrokenResource(jedis);
                jedisPool.returnResource(jedis);
                jedisPool.returnResourceObject(jedis);*/
                //高版本jedis close 取代池回收
                jedis.close();
            }
        } catch (Exception e) {
            log.error("释放资源异常：" + e);
        }
    }
}
