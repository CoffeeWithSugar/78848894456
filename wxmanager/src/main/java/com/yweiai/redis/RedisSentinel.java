package com.yweiai.redis;

import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * redis连接池配置
 * redis-sentinel哨兵集群模式
 * @author wj
 */
public class RedisSentinel {

    private static JedisSentinelPool jedisSentinelPool = null;

    private static JedisPoolConfig config = null;

    private static Integer clusterType = null;

    /**
     * 获取redis连接
     *
     * @return
     */
    public static Jedis getJedis() {
        if (jedisSentinelPool == null) {
            synchronized(RedisSentinel.class){
                if(jedisSentinelPool==null){
                    initJedisPool();
                }
            }
        }
        return jedisSentinelPool.getResource();
    }

    /**
     * 归还连接
     *
     * @param jedis
     */
    public static void releaseJedis(Jedis jedis) {
        jedisSentinelPool.returnResource(jedis);
    }


    /**
     * 初始化redis连接池
     */
    private static void initJedisPool() {
        //读取配置文件
        InputStream in = null;
        Properties prop = new Properties();
        try {
            in = RedisSentinel.class.getClassLoader().getResourceAsStream("redisPoolConfig.properties");
            prop.load(in);
            //判断集群类型1：sentinel  2:redis-cluster
            clusterType = Integer.parseInt(prop.getProperty("CLUSTER_TYPE"));
            if (clusterType != null && clusterType == 1) {
                config = new JedisPoolConfig();
                //最大空闲连接数
                config.setMaxIdle(Integer.parseInt(prop.getProperty("MAX_IDLE")));
                //最大连接数
                config.setMaxTotal(Integer.parseInt(prop.getProperty("MAX_ACTIVE")));
                //最大阻塞时间
                config.setMaxWaitMillis(Integer.parseInt(prop.getProperty("MAX_WAIT")));
                //sentinel节点
                String sentinels = prop.getProperty("SENTINEL_NODES");
                if (!StringUtils.isEmpty(sentinels)) {
                    String[] sentinelNodes = sentinels.split(",");
                    Set<String> nodes = new HashSet<>();
                    for (String i : sentinelNodes) {
                        nodes.add(i);
                    }
                    jedisSentinelPool = new JedisSentinelPool(prop.getProperty("MASTER_NAME"), nodes, config);
                } else {
                    throw new Exception("读取sentinel节点配置失败，请检查配置文件是否有误");
                }
            } else {
                System.out.println("redis-cluster模式。。");
            }

        } catch (Exception e) {
            System.out.println("初始化redis连接池失败");
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Jedis jedis = RedisSentinel.getJedis();
        jedis.set("sentinel_test", "redis sentinel cluster");
        jedis.set("wj", "wujian");
        System.out.println(jedis.get("test"));
        System.out.println(jedis.keys("*"));
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println("key=" + key + "||value=" + jedis.get(key));
        }
        RedisSentinel.releaseJedis(jedis);
    }

}
