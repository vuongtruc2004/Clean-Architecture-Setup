package org.yourapp.order.usecase;

import org.yourapp.order.command.CreateOrderCommand;
import org.yourapp.order.mapper.OrderItemMapper;
import org.yourapp.order.mapper.OrderMapper;
import org.yourapp.order.model.Order;
import org.yourapp.order.model.OrderItem;
import org.yourapp.order.port.in.CreateOrderInputPort;
import org.yourapp.order.port.out.OrderRepository;
import org.yourapp.order.result.OrderResult;
import org.yourapp.user.exception.UserNotFoundException;
import org.yourapp.user.port.out.UserRepository;

import java.util.List;

public class CreateOrderUseCase implements CreateOrderInputPort {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderItemMapper orderItemMapper;
    private final OrderMapper orderMapper;

    public CreateOrderUseCase(
            OrderRepository orderRepository,
            UserRepository userRepository,
            OrderItemMapper orderItemMapper,
            OrderMapper orderMapper
    ) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderItemMapper = orderItemMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderResult createOrder(CreateOrderCommand command) {
        if (!userRepository.existsById(command.userId())) {
            throw new UserNotFoundException(command.userId());
        }

        List<OrderItem> orderItems = command.orderItems()
                .stream()
                .map(orderItemMapper::mapCreateOrderItemCommandToOrderItem)
                .toList();

        Order order = Order.create(command.userId(), orderItems);

        Order savedOrder = orderRepository.save(order);
        return orderMapper.mapOrderToOrderResult(savedOrder);
    }
}
