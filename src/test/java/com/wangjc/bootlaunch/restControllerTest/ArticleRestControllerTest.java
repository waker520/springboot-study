package com.wangjc.bootlaunch.restControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangjc.bootlaunch.controller.ArticleRestController;
import com.wangjc.bootlaunch.model.ArticleVO;
import com.wangjc.bootlaunch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//@Transactional        //不建议在spring boot集成测试中使用该注解，它将事务交给spring管理，正常情况为数据库进行管理
@Slf4j
//@SpringBootTest     //是用来创建Spring的上下文ApplicationContext，保证测试在上下文环境里运行。并且构建servlet容器，加载spring 中的bean
@AutoConfigureMockMvc   //自动创建mockmvc  使用该注解不需要before手动创建mockmvc
@WebMvcTest(ArticleRestController.class)    //轻量级测试，@SpringBootTest加载spring中的所有bean，而该注解注入指定的bean
class ArticleRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean       //伪造一个bean，模拟业务场景，并不正的实现
    private ArticleRestService articleRestService;

    /*@BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
    }*/

    @Test
    public void saveArticle() throws Exception {
        String articleVO = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"wangjc\",\n" +
                "    \"title\": \"手摸手教你开发spring boot\",\n" +
                "    \"content\": \"c\",\n" +
                "    \"createTime\": \"2017-07-16 05:23:34\",\n" +
                "    \"reader\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        ArticleVO articleObj = objectMapper.readValue(articleVO,ArticleVO.class);

        //打桩
        when(articleRestService.saveArticle(articleObj)).thenReturn("ok");



        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/articles")
                        .contentType("application/json").content(articleVO))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("wangjc"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                .andDo(print())
                .andReturn();

        log.info(result.getResponse().getContentAsString());

    }
}
