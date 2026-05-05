package org.yourapp.configuration.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yourapp.order.mapper.command.OrderItemCommandMapper;
import org.yourapp.order.mapper.result.OrderItemResultMapper;
import org.yourapp.order.mapper.result.OrderResultMapper;
import org.yourapp.order.port.in.CreateOrderInputPort;
import org.yourapp.order.port.out.OrderRepository;
import org.yourapp.order.usecase.CreateOrderUseCase;
import org.yourapp.user.port.out.UserRepository;

@Configuration
public class OrderConfig {

    @Bean
    public OrderItemCommandMapper orderItemCommandMapper() {
        return new OrderItemCommandMapper();
    }

    @Bean
    public OrderItemResultMapper orderItemResultMapper() {
        return new OrderItemResultMapper();
    }

    @Bean
    public OrderResultMapper orderResultMapper(OrderItemResultMapper orderItemResultMapper) {
        return new OrderResultMapper(orderItemResultMapper);
    }

    @Bean
    public CreateOrderInputPort createOrderInputPort(
            OrderRepository orderRepository,
            UserRepository userRepository,
            OrderItemCommandMapper orderItemCommandMapper,
            OrderResultMapper orderResultMapper
    ) {
        return new CreateOrderUseCase(
                orderRepository,
                userRepository,
                orderItemCommandMapper,
                orderResultMapper
        );
    }
}
