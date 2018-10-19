package com.my.accountbook.project.service.impl;

import com.my.accountbook.project.dao.UserMapper;
import com.my.accountbook.project.entity.User;
import com.my.accountbook.project.entity.UserExample;
import com.my.accountbook.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User get(User record) throws Exception {
        UserExample userExample = new UserExample();
        UserExample.Criteria userExampleCriteria = userExample.createCriteria();
        Integer id = record.getId();
        String username = record.getUsername();
        if (id != null) {
            userExampleCriteria.andIdEqualTo(id);
        } else if (username != null) {
            userExampleCriteria.andUsernameEqualTo(username);
        } else {
            throw new RuntimeException("Parameter is missing");
        }
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && userList.size() != 0) {
            return userList.get(0);
        } else {
            throw new RuntimeException("User does not exist");
        }

    }

    @Override
    public int edit(User record) {
        int flag = 0;
        if (record != null && record.getId() != null) {
            flag = userMapper.updateByPrimaryKeySelective(record);
        } else if (record != null && record.getId() == null) {
            flag = userMapper.insertSelective(record);
        }
        return flag;
    }
}
