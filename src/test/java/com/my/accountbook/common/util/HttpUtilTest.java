package com.my.accountbook.common.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HttpUtilTest {
    @Test
    public void testPost() {
        String url = "http://www.hht.one/exchange-web-api/common/user_info";
        Map<String, String> headers = new HashMap<>();

        headers.put("exchange-token", "0d01e338bc9c6930d82778ea0007671f58c6c5df08354ab286620dced6c27b06");
        String result = HttpUtil.post(url, headers, null);
        System.out.println(result);
    }
}
