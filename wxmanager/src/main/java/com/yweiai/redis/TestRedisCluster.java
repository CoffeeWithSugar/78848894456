package com.yweiai.redis;

import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.Date;

/**
 * redis-cluster集群测试
 *
 * @author wj
 */
public class TestRedisCluster {
    public static void main(String[] args) throws IOException {

        for (int i = 1; i <= 200; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    JedisCluster jedis = RedisCluster.getCluster();
                    for (int j = 0; j < 200; j++) {
                        String key = Thread.currentThread().getName() + "-" + j;
                        String value = new Date().toString();
                        jedis.set(key, value);
                        System.out.println(Thread.currentThread().getName() + ":" + "key=" + key + "   value=" + value);
                    }
                }
            };
            t.setName("thread-" + i);
            t.start();
        }
    }
}
