package com.fuwei.util;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

/**
 * ClassName:MemcachedClient <br/>
 * Function: Memcached客户端. <br/>
 * Date:     2017年2月22日 下午1:32:26 <br/>
 * @author   qiyongkang
 * @version
 * @since    JDK 1.6
 * @see
 */
public class MemcachedClient {
    public static void main(String[] args) {
        // 初始化SockIOPool，管理memcached的连接池
        String[] servers = { "47.94.14.145:11211" };
        SockIOPool pool = SockIOPool.getInstance();
        pool.setServers(servers);
        pool.setFailover(true);
        pool.setInitConn(10);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaintSleep(30);
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setAliveCheck(true);
        pool.initialize();
        // 建立MemcachedClient实例
        MemCachedClient memCachedClient = new MemCachedClient();
        // 将对象加入到memcached缓存
        boolean success = memCachedClient.set("name", "qiyongkang");
        // 从memcached缓存中按key值取对象
        String result = (String) memCachedClient.get("name");
        System.out.println(String.format("set:" + success));
        System.out.println(String.format("get:" + result));
    }
}
