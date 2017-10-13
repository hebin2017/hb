package com.maiyuan.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ywj on 2017/7/3.
 */
@EnableWebMvc//启动MVC
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   /* @Bean
    public ShardedJedisPool shardedJedisPool() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(5);
        config.setMaxTotal(40);
        config.setMinIdle(2);
        config.setMaxWaitMillis(1000);
        config.setTestOnBorrow(false);
        config.setTestOnReturn(false);
        List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
        JedisShardInfo info = new JedisShardInfo("127.0.0.1", "6379");
        list.add(info);
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(config, list);
        return shardedJedisPool;
    }*/

}