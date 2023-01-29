package com.eltmvl.board129.web;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
/*
    when I run this test, other conf instead of inner conf in JUnit
    using Spring conf (SpringRunner)
    connector between springboot test and JUnit
*/
@WebMvcTest(controllers = HelloController.class)
@AutoConfigureMockMvc
public class HelloControllerTest {
    @Autowired
    // receive Bean managed by Spring

    private MockMvc mvc;
    /* using in testing Web API
       start point spring MVC test
    */
    @Test
    public void hello_return() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")).andExpect(status().isOk())
                /* verify result of mvc.perform
                   OK = 200
                */
                .andExpect(content().string(hello));
    }
    @Test
    public void helloDto_return() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name", name)
                                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
    }

}