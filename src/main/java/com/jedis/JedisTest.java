package com.jedis;

import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.Set;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis =new Jedis("127.0.0.1",6379);
        jedis.auth("yinfeng2012");
        jedis.select(11);
        jedis.set("k1","v1");
        System.out.println(jedis.get("k1"));
        Set<String> keys = jedis.keys("*");
        String string = keys.toString();
        jedis.close();
    }
}
