package com.mengka.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  获取推送的消息的数据
 *
 * User: mengka
 * Date: 14-6-25
 * Time: 下午4:53
 */
public class MkRedisClient{

    private static Jedis jedis;
    private static JedisPool pool;
    private static String host;
    private static int port = 6379;
    private static int timeout = 60 * 1000;

    static {
        host = "192.168.1.105";//测试直播redis

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(20);
        config.setTestOnBorrow(false);
        pool = new JedisPool(config, host, port, timeout);// 线程数量限制，IP地址，端口，超时时间
        jedis = pool.getResource();
    }

    private static class MkRedisClientHolder{
        public static final MkRedisClient MkRedisClient_Holder = new MkRedisClient();
    }

    public static MkRedisClient getInstance() {
        return MkRedisClientHolder.MkRedisClient_Holder;
    }

    public static MkRedisClient getZhiboInstance() {
        return MkRedisClientHolder.MkRedisClient_Holder;
    }

    public String getItem(String key){
        return jedis.get(key);
    }

    public void addItem(String key,String data){
        jedis.set(key, data);
    }

    public void addItemSet(String key,String data){
        jedis.sadd(key, data);
    }

    public Set<String> getItemSet(String key){
        return jedis.smembers(key);
    }

    public List<String> getItemList(String key,int start, int end){
        return jedis.lrange(key, start, end);
    }

    public long getItemListSize(String key){
        return jedis.llen(key);
    }

    public List<String> getItemList(String key){
        long len = jedis.llen(key);
        if(len==0){
            return null;
        }
        List<String> list = jedis.lrange(key, 0, (int)len);
        return list;
    }

    public String getItemList(String key,int index){
        return jedis.lindex(key,index);
    }

    /**
     * rpush:在key对应list的尾部添加字符串元素
     * lpush:在key对应list的头部添加字符串元素
     *
     * @param key
     * @param value
     */
    public void addItemList(String key,String value){
        jedis.rpush(key, value);
    }

    /**
     *  删除value的元素，count是存在多个value元素的时候，删除的个数
     *
     * @param key
     * @param count
     * @param value
     */
    public void removeItemList(String key,int count,String value){
        jedis.lrem(key, count, value);
    }

    /**
     *  修改list指定位置的值
     *
     * @param key
     * @param index
     * @param value
     */
    public void setItemList(String key,int index,String value){
        jedis.lset(key, index, value);
    }

    /**
     *  返回给定key的剩余生存时间(以秒为单位)
     *
     * @param key
     * @return
     */
    public Long ttl(String key){
        return jedis.ttl(key);
    }

    /**
     *  删除数据
     *
     * @param key
     */
    public void delete(String key){
        jedis.del(key);
    }

    /**
     *  可以排序的redis值添加
     *
     * @param key
     * @param score  根据的排序字段
     * @param member
     */
    public void zaddString(String key, double score, String member){
        jedis.zadd(key, score, member);
    }

    /**
     *  取出score在[fromValue,toValue]之间的元素值
     *
     * @param key
     * @param fromValue
     * @param toValue
     */
    public Set<String> zrangeByScoreString(String key,Integer fromValue,Integer toValue){
        return jedis.zrangeByScore(key,fromValue,toValue);
    }

    /**
     *  从小到大返回
     *
     * @param key
     * @param fromValue
     * @param toValue
     * @param offset
     * @param count
     * @return
     */
    public Set<String> zrangeByScoreString(String key,Double fromValue,Double toValue, int offset, int count){
        return jedis.zrangeByScore(key,fromValue,toValue,offset,count);
    }

    /**
     *  从大到小返回元素
     *
     * @param key
     * @param maxScore 最大值
     * @param minScore 最小值
     * @param offset 起始index，默认从第0个开始的count个返回
     * @param count  返回的个数
     * @return
     */
    public Set<String> zrevrangeByScoreString(String key, double maxScore, double minScore, int offset, int count) {
        return jedis.zrevrangeByScore(key,maxScore,minScore,offset,count);
    }

    /**
     *  将指定的hash filed 加上指定值。成功返回hash filed 变更后的值
     *
     * @param key
     * @param field  主key下面对应的key
     * @param step
     * @return
     */
    public Long hIncrBy(String key, String field, long step){
        return jedis.hincrBy(key,field,step);
    }

    /**
     * 获取hIncrBy添加的数据
     *
     * @param key
     * @return
     */
    public Map<String, String> hgetAll(String key){
        return jedis.hgetAll(key);
    }

    public List<String> hvals(String key){
        return jedis.hvals(key);
    }
}
