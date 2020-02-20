package com.groot.groot.Controllers;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GuardianController.class)
class GuardianControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getMessage_WithParameter() throws Exception {
        mockMvc.perform(get("/groot?message=asdasd"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.received", is("asdasd")))
                .andExpect(jsonPath("$.translated", is("I'm Groot!")))
                .andReturn();
    }

    @Test
    public void getMessage_WithoutParameter() throws Exception {
        mockMvc.perform(get("/groot"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("I'm Groot!")))
                .andReturn();
    }

    @Test
    public void getArrowSpeed_WithParameter() throws Exception {

        mockMvc.perform(get("/yondu?distance=100.0&time=10.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.distance", is(100.0)))
                .andExpect(jsonPath("$.time", is(10.0)))
                .andExpect(jsonPath("$.speed", is(10.0)))
                .andReturn();
    }

    @Test
    public void getArrowSpeed_WithoutParameter() throws Exception {

        mockMvc.perform(get("/yondu"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error", is("No parameters were given!")))
                .andReturn();
    }
}