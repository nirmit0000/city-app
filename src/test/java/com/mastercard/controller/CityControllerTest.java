package com.mastercard.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testWhenCitiesAreConnectedThenReturnTrue() throws Exception {
        this.mockMvc.perform(get("/connected?origin=Newark&destination=philadelphia")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));
    }

    @Test
    public void testWhenCitiesAreNotConnectedThenReturnFalse() throws Exception {
        this.mockMvc.perform(get("/connected?origin=Boston&destination=philadelphia")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("false")));

    }
}
