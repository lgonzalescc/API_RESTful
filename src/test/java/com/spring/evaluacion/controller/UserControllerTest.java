package com.spring.evaluacion.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.evaluacion.dto.request.PhoneRequest;
import com.spring.evaluacion.dto.request.UserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateUserSuccessfully() throws Exception {
        UserRequest request = new UserRequest();
        request.setName("Luis Gonzales");
        request.setEmail("luis" + System.currentTimeMillis() + "@example.com");
        request.setPassword("Luis27042025#");
        request.setPhones(Collections.singletonList(new PhoneRequest("987654321", "01", "51")));

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldFailWhenInvalidEmail() throws Exception {
        UserRequest request = new UserRequest();
        request.setName("Luis Gonzales");
        request.setEmail("luisinvalidemail");
        request.setPassword("Luis27042025#");
        request.setPhones(Collections.singletonList(new PhoneRequest("987654321", "01", "51")));

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}
