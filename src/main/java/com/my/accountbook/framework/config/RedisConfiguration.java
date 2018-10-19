package com.my.accountbook.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableRedisHttpSession
public class RedisConfiguration {
    @Autowired
    private RedisProperties properties;

    /**
     * 注入jedisPool
     * 用于手动调用jedisPool.getResource().set()/get()
     *
     * @return
     */
    @Bean
    public JedisPool getJedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(properties.getJedis().getPool().getMaxIdle());
        config.setMaxTotal(properties.getJedis().getPool().getMaxActive());
        config.setMaxWaitMillis(properties.getJedis().getPool().getMaxWait().toMillis());
        JedisPool pool = new JedisPool(config, properties.getHost(), properties.getPort(), 100, properties.getPassword(), properties.getDatabase());
        return pool;
    }
}
