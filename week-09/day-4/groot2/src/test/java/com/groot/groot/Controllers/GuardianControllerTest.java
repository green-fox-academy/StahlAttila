package com.groot.groot.Controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GuardianController.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class GuardianControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            StandardCharsets.UTF_8);


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

    @Test
    public void getCargo() throws Exception {

        mockMvc.perform(get("/rocket"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("caliber25", is(0)))
                .andExpect(jsonPath("caliber30", is(0)))
                .andExpect(jsonPath("caliber50", is(0)))
                .andExpect(jsonPath("shipstatus", is("empty")))
                .andExpect(jsonPath("ready", is(false)));
    }

    @Test
    public void fillCargo_With_Parameters_To_MaxOut_The_Ship () throws Exception {

        mockMvc.perform(get("/rocket/fill")
                .param("caliber", ".25")
                .param("amount", "12500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("received", is(".25")))
                .andExpect(jsonPath("amount", is(12500)))
                .andExpect(jsonPath("shipstatus", is("full")))
                .andExpect(jsonPath("ready", is(true)))
                .andDo(print());
    }

    @Test
    public void fillCargo_With_Parameters_To_Overload_The_Ship () throws Exception {

        mockMvc.perform(get("/rocket/fill")
                .param("caliber", ".25")
                .param("amount", "12501"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("received", is(".25")))
                .andExpect(jsonPath("amount", is(12501)))
                .andExpect(jsonPath("shipstatus", is("overloaded")))
                .andExpect(jsonPath("ready", is(false)))
                .andDo(print());
    }

    @Test
    public void fillCargo_WithOut_Parameters () throws Exception {

        mockMvc.perform(get("/rocket/fill")
                .param("amount", "12501"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("error", is("There were no parameters given!")))
                .andDo(print());
    }

    @Test
    public void addFood() throws Exception {

        String [] empty = null;

        mockMvc.perform(get("/drax"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", is(ArrayList.class)))
                .andExpect(jsonPath("$.*", hasSize(0)))
                .andDo(print());

        mockMvc.perform(post("/drax/add-food")
                .param("name", "pizza")
                .param("amount", "123.1")
                .param("calorie", "111.1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("pizza")))
                .andDo(print());

        mockMvc.perform(get("/drax"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.foodList.name", is("pizza")))
                .andDo(print());
    }


}