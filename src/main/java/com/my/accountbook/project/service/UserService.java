package com.my.accountbook.project.service;

import com.my.accountbook.project.entity.User;

public interface UserService {
    User get(User record);

    int edit(User record);
}
