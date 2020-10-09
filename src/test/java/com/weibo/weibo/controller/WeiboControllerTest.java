package com.weibo.weibo.controller;

import com.weibo.weibo.WeibowebApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URLDecoder;
import java.net.URLEncoder;

@Slf4j
@SpringBootTest()
public class WeiboControllerTest {

    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @BeforeEach
    public void setup(){
        log.info("测试开始...");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void query() throws Exception{
        String keyword = "新冠";
        String keyword_utf8 = URLDecoder.decode(keyword, "UTF-8");
        String get_url = "/getWeibo/" + keyword_utf8 + "/1";
        String result = mockMvc.perform(MockMvcRequestBuilders.get(get_url))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn()
                .getResponse()
                .getContentAsString();
        log.info(result);
    }
}
