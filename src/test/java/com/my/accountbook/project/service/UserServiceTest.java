package com.my.accountbook.project.service;

import com.my.accountbook.Application;
import com.my.accountbook.project.dao.UserMapper;
import com.my.accountbook.project.entity.User;
import com.my.accountbook.project.entity.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisPool;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserServiceTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void testRedisSet() {
        System.out.println(jedisPool.getResource().set("user_1", "Hello world :-)"));
    }

    @Test
    public void testRedisGet() {
        System.out.println(jedisPool.getResource().get("user_1"));
    }

    @Test
    public void testGet() {
        UserExample userExample = new UserExample();
        UserExample.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andUsernameEqualTo("yimcarson");
        User user = userMapper.selectByExample(userExample).get(0);
        System.out.println(user);
    }
}
