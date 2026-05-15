package org.yourapp.order.controller.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.yourapp.order.request.CreateOrderItemRequest;
import org.yourapp.order.request.CreateOrderRequest;
import tools.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Container
    @ServiceConnection
    static final MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("clean_architecture_setup_test")
            .withUsername("test")
            .withPassword("1234");

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createOrder_RightCreateOrderRequest_Return201() throws Exception {
        //Arrange (Given)
        CreateOrderRequest request = CreateOrderRequest.builder()
                .userId(1L)
                .orderItems(List.of(
                        CreateOrderItemRequest.builder()
                                .productId(1L)
                                .quantity(10)
                                .unitPrice(BigDecimal.valueOf(15.6))
                                .build()
                ))
                .build();

        // Act + Assert (When + Then)
        mockMvc.perform(post("/api/v1/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        ;
    }
}