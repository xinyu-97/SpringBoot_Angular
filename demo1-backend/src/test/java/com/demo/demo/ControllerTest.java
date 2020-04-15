package com.demo.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void test() throws Exception{
        mvc.perform(get("/getCombination?input=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("1"))
                .andReturn();
    }
}
