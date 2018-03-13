package com.fuwei.util;
;import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

/**
 * Created by ${MIND-ZR} on 2017/11/25.
 */
public class MemcachedUtil{
    //创建全局的唯一实例
    protected static MemCachedClient mcc = new MemCachedClient();

    protected static MemcachedUtil memCached = new MemcachedUtil();

    //设置与缓存服务器的连接池
    /*static {
//服务器列表和其权重，个人memcached地址和端口号
        String[] servers = {"47.94.14.145:11211"};
        Integer[] weights = {3};

        //获取socke连接池的实例对象
        SockIOPool pool = SockIOPool.getInstance();

        // 设置服务器信息
        pool.setServers( servers );
        pool.setWeights( weights );

        //设置初始连接数、最小和最大连接数以及最大处理时间
        pool.setInitConn(5);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaxIdle(100*60*60*6);

        //设置主线程的睡眠时间
        pool.setMaintSleep(60);

        //设置TCP的参数，连接超时等
        pool.setNagle(false);
        pool.setSocketTO(60);
        pool.setSocketConnectTO(0);

        //初始化连接池
        pool.initialize();

        //压缩设置，超过指定大小的都压缩
//      cachedClient.setCompressEnable(true);
//      cachedClient.setCompressThreshold(1024*1024);

    }*/

    /**
     * 保护型构造方法，不允许实例化！
     *
     */
    protected MemcachedUtil()
    {

    }

    /**
     * 获取唯一实例.
     * @return
     */
    public static MemcachedUtil getInstance()
    {
        return memCached;
    }

    /**
     * 添加一个指定的值到缓存中.
     * @param key
     * @param value
     * @return
     */
    public static boolean add(String key,Object value){
        return mcc.add(key,value);
    }

    public static boolean add(String key, Object value, Integer expity){
        return mcc.add(key, value, expity);
    }


    /**
     * 新建？一个指定的值到缓存中.
     * @param key
     * @param value
     * @return
     */
    public static boolean put(String key,Object value){return mcc.set(key, value);}

    public static boolean put(String key,Object value,Integer expity){return mcc.set(key, value, expity);}

    /**
     * 替换一个指定的值到缓存中.
     * @param key
     * @param value
     * @return
     */
    public static boolean replace(String key,Object value){
        return mcc.replace(key, value);
    }

    public static boolean replace(String key,Object value,Integer expity){
        return mcc.replace(key, value, expity);
    }

    /**
     * 删除一个指定的值到缓存中.
     * @param key
     * @return
     */
    public static boolean delete(String key){
        return mcc.delete(key);
    }

    /**
     * 根据指定的关键字获取对象.
     * @param key
     * @return
     */
    public static Object get(String key){
        return mcc.get(key);
    }



}