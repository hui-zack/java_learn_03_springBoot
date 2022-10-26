package com.hui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest(
        /* 启动测试用的web服务器 */
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        /* 自定义测试数据 */
        properties = {"test.prop=testValue"}
)

/* 开启虚拟请求 */
@AutoConfigureMockMvc
/* 测试类添加事务注解时, 表示该事务不提交 */
@Transactional
class ApplicationTests {
    @Value("${test.prop}")
    private String msg;

    @Test
    void contextLoads() {
        System.out.println(msg);
    }


    @Autowired
    private MockMvc mvc;

    /* 测试响应状态 */
    @Test
    void testUserControllerStatus() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user");
        // 请求真实值
        ResultActions action = mvc.perform(builder);
        // 设定预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // 设定预期值为成功, 状态200
        ResultMatcher ok = status.isOk();
        // 预期值与真实值进行匹配
        action.andExpect(ok);
    }

    /* 测试响应头数据 */

    @Test
    void testUserControllerHeader() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user/testConfig");
        // 请求真实值
        ResultActions action = mvc.perform(builder);
        // 设定预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");

        // 预期值与真实值进行匹配
        action.andExpect(contentType);
    }

    /* 测试响应体字符串数据 */
    @Test
    void testUserControllerBody() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user");
        // 请求真实值
        ResultActions action = mvc.perform(builder);
        // 设定预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher hello_springBoot = content.string("hello SpringBoot");

        // 预期值与真实值进行匹配
        action.andExpect(hello_springBoot);
    }

    /* 测试响应体json数据 */
    @Test
    void testUserControllerBodyJson() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user/testConfig");
        // 请求真实值
        ResultActions action = mvc.perform(builder);
        // 设定预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher resultMatcher = content.json("{\"name\":\"hui\",\"age\":16,\"classArray\":[\"java\",\"python\",\"vue\",\"\"]}");

        // 预期值与真实值进行匹配
        action.andExpect(resultMatcher);
    }
}
