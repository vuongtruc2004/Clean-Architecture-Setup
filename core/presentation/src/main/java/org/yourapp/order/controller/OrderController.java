package org.yourapp.order.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yourapp.order.command.CreateOrderCommand;
import org.yourapp.order.mapper.request.OrderRequestMapper;
import org.yourapp.order.mapper.response.OrderResponseMapper;
import org.yourapp.order.port.in.CreateOrderInputPort;
import org.yourapp.order.request.CreateOrderRequest;
import org.yourapp.order.response.OrderResponse;
import org.yourapp.order.result.OrderResult;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRequestMapper orderRequestMapper;
    private final OrderResponseMapper orderResponseMapper;
    private final CreateOrderInputPort createOrderInputPort;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        CreateOrderCommand createOrderCommand = orderRequestMapper.mapCreateOrderRequestToCreateOrderCommand(request);
        OrderResult orderResult = createOrderInputPort.createOrder(createOrderCommand);
        OrderResponse orderResponse = orderResponseMapper.mapOrderResultToOrderResponse(orderResult);
        return ResponseEntity.ok(orderResponse);
    }
}
