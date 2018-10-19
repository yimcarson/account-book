package com.my.accountbook.common.controller;

import com.my.accountbook.common.pojo.ApiResult;
import com.my.accountbook.common.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring session 以来于init()
 * 统一异常处理
 */
@Controller
public class BaseController {
    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ModelAttribute
    public void init(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        /*
        spring session 工作原理：controller层注入HttpServletRequest对象，显示地调用getSession()，可以将请求的ServletRequest对象交由spring管理，并自动在响应中添加Set-Cookie

         */
        request.getSession();
        String ip = HttpUtil.getIPAddress(request);
        logger.info("ip:" + ip);

    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ApiResult<Exception> exception(Exception e) {
        e.printStackTrace();
        ApiResult<Exception> result = new ApiResult<Exception>();
        result.setCode(1);
        result.setData(e);
        result.setMsg(e.getMessage());
        return result;
    }
}
