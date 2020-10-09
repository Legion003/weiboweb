package com.weibo.weibo.controller;

import com.weibo.weibo.WeibowebApplication;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
        log.info(get_url);
        MvcResult mvcResult = null;
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getWeibo/%E6%96%B0%E5%86%A0/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
        JSONObject jsonObject = new JSONObject(mvcResult.getResponse().getContentAsString());

        log.info(jsonObject.toString());
    }
}
