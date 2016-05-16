package com.mengka.redis;

import java.util.List;

/**
 * @author heidou.f
 *         2016/5/16.
 */
public class redis_1 {
    private static MkRedisClient redisClient = MkRedisClient.getInstance();

    public static void main(String[] args) {
        String key = "key_20160516232";
        redisClient.addItem(key, "1232311");

        String key2 = "key_20160556516_2";
        redisClient.addItemList(key2,"8711");
        redisClient.addItemList(key2,"2922");
        redisClient.addItemList(key2,"3373");

        String value = redisClient.getItem(key);
       System.out.println(value);
        List<String> list = redisClient.getItemList(key2);
        for(String tmp:list){
            System.out.println("tmp = "+tmp);
        }

    }
}
