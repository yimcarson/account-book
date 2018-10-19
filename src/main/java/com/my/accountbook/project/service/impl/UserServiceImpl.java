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
    public User get(User record) {
        UserExample userExample = new UserExample();
        UserExample.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andIsDeleteEqualTo(false);
        Integer id = record.getId();
        String username = record.getUsername();
        Boolean isDelete = record.getIsDelete();
        if (id != null) {
            userExampleCriteria.andIdEqualTo(id);
        }
        if (username != null) {
            userExampleCriteria.andUsernameEqualTo(username);
        }
        if (isDelete != null) {
            userExampleCriteria.andIsDeleteEqualTo(isDelete);
        }
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && userList.size() != 0) {
            return userList.get(0);
        } else {
            return null;
        }

    }

    @Override
    public int edit(User record) {
        int flag = 0;
        try {
            if (record != null && record.getId() != null) {
                flag = userMapper.updateByPrimaryKeySelective(record);
            } else if (record != null && record.getId() == null) {
                flag = userMapper.insertSelective(record);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return flag;
    }
}
