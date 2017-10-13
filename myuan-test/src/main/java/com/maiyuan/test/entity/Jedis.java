package com.maiyuan.test.entity;

import com.maiyuan.test.Application;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by Administrator on 2017/9/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Jedis {
    @Autowired
    private ShardedJedisPool shardedJedisPool;
    @org.junit.Test
    public void test(){
        shardedJedisPool.getResource().set("A","123456");
        System.out.println(shardedJedisPool.getResource().get("A"));
    }
}
