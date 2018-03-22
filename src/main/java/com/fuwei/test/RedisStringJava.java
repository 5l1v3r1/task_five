package com.fuwei.test;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisStringJava {
    @Test
    public  void it() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("47.94.14.145",6379);
       jedis.auth("666666");
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("A", "好的");

        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.getrange("student2",27,1000));
        System.out.println("redis 存储的字符串为: "+ jedis.ping());
    }
}