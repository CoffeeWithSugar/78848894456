package com.yweiai.redis;

import org.springframework.util.StringUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * redis-cluster连接
 * @author wj
 * @description JedisCluster底层使用了连接池，可以限制最大连接数
 */
public class RedisCluster {

    private static JedisCluster cluster=null;
    private static JedisPoolConfig config=null;

    /**
     * 使用双重同步锁，确保redis-cluster只被初始化一次
     * @return
     */
    public static JedisCluster getCluster(){
        if(cluster==null){
            synchronized(RedisCluster.class){
                if(cluster==null){
                    initJedisCluster();
                }
            }
        }
        return cluster;
    }

    /**
     * redis-cluster初始化
     * @author wj
     */
    private static void initJedisCluster() {
        InputStream in = null;
        Properties prop = new Properties();
        try {
            System.out.println(Thread.currentThread().getName()+"-init redis cluster......");
            in = RedisCluster.class.getClassLoader().getResourceAsStream("redisPoolConfig.properties");
            prop.load(in);
            System.out.println("redis-cluster模式。。");
            config = new JedisPoolConfig();
            //最大空闲连接数
            config.setMaxIdle(Integer.parseInt(prop.getProperty("MAX_IDLE")));
            //最大连接数
            config.setMaxTotal(Integer.parseInt(prop.getProperty("MAX_ACTIVE")));
            //最大阻塞时间
            config.setMaxWaitMillis(Integer.parseInt(prop.getProperty("MAX_WAIT")));
            //sentinel节点
            String clusterNodes = prop.getProperty("CLUSTER_NODES");
            System.out.println("cluster-nodes:" + clusterNodes);
            if (!StringUtils.isEmpty(clusterNodes)) {
                String[] nodeArr = clusterNodes.split(",");
                Set<HostAndPort> nodes=new HashSet<>();
                for (String i : nodeArr) {
                    String[] hostPort = i.split(":");
                    nodes.add(new HostAndPort(hostPort[0],Integer.parseInt(hostPort[1])));
                }
                cluster=new JedisCluster(nodes,config);
            }
        }catch (Exception e){
            System.out.println("初始化redisCluster..失败");
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        JedisCluster jedis = RedisCluster.getCluster();
        jedis.set("sentinel_test", "redis sentinel cluster");
        jedis.set("wj", "wujian");
        System.out.println(jedis.get("sentinel_test"));
        System.out.println(jedis.get("wj"));
        jedis.close();
    }
}
