package com.my.accountbook.project.controller;

import com.my.accountbook.common.controller.BaseController;
import com.my.accountbook.project.entity.User;
import com.my.accountbook.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

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
    public User signIn(@RequestBody User user, HttpServletRequest request) {
        logger.info("Request parameters is {}", user.toString());
        logger.info("Session id is {}" + request.getSession().getId());
        try {
            user = userServiceImpl.get(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User signUp(@RequestBody User user, HttpServletRequest request) {
        logger.info("Request parameters is {}", user.toString());
        logger.info("Session id is {}" + request.getSession().getId());
        try {
            int flag = userServiceImpl.edit(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(HttpServletRequest request) {
//        logger.info("Session id is {}", request.getSession().getId());
        return "Hello world :-)";
    }
}
