package com.my.accountbook.project.controller;

import com.my.accountbook.common.controller.BaseController;
import com.my.accountbook.common.pojo.ApiResult;
import com.my.accountbook.common.util.HttpUtil;
import com.my.accountbook.project.entity.User;
import com.my.accountbook.project.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    public static String USER_PASSWORD_SALT = "7add2c10-cdc0-43af-9de4-43d669d43fa0";

    @Autowired
    private UserService userServiceImpl;


    @RequestMapping("/{id}")
    public String get(Model model, @PathVariable(value = "id") Integer id) {
//        logger.info("Session id is {}", request.getSession().getId());
        User record = new User();
        record.setId(id);
        User user = null;
        try {
            user = userServiceImpl.get(record);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ApiResult<User> signIn(@RequestBody User user, HttpServletRequest request) {
        logger.info("Request parameters is {}", user.toString());
        logger.info("Session id is {}" + request.getSession().getId());
        String password = user.getPassword();
        String username = user.getUsername();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new RuntimeException("Required parameter missing.");
        }
        User record = new User();
        record.setUsername(username);
        record.setIsDelete(false);
        record = userServiceImpl.get(user);
        if (record == null || !record.getPassword().equals(DigestUtils.md5Hex(password + USER_PASSWORD_SALT))) {
            throw new RuntimeException("Wrong username or password.");
        }
        return new ApiResult(0, "SUCCESS", user);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ApiResult<User> signUp(@RequestBody User user, HttpServletRequest request) {
        logger.info("Request parameters is {}", user.toString());
        logger.info("Session id is {}" + request.getSession().getId());

        String password = user.getPassword();
        String username = user.getUsername();
        User record = new User();
        record.setUsername(username);
        if (userServiceImpl.get(record) != null) {
            throw new RuntimeException("User name already exists.");
        }
        password = DigestUtils.md5Hex(password + USER_PASSWORD_SALT);
        user.setPassword(password);
        user.setId(null);
        user.setSigninIp(HttpUtil.getIPAddress(request));
        user.setSigninTime(new Date());
        user.setSignupTime(new Date());
        int flag = userServiceImpl.edit(user);
        if (flag > 0) {
            return new ApiResult(0, "SUCCESS", user);
        } else {
            throw new RuntimeException("Sign up has failed.");
        }
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(HttpServletRequest request) {
//        logger.info("Session id is {}", request.getSession().getId());
        return "Hello world :-)";
    }
}
