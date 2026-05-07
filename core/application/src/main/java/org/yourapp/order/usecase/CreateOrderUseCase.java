package org.yourapp.order.usecase;

import org.yourapp.order.command.CreateOrderCommand;
import org.yourapp.order.mapper.command.OrderItemCommandMapper;
import org.yourapp.order.mapper.result.OrderResultMapper;
import org.yourapp.order.model.Order;
import org.yourapp.order.model.OrderItem;
import org.yourapp.order.port.in.CreateOrderInputPort;
import org.yourapp.order.port.out.OrderRepository;
import org.yourapp.order.result.OrderResult;
import org.yourapp.shared.exception.NotFoundException;
import org.yourapp.user.exception.UserApplicationErrorCode;
import org.yourapp.user.port.out.UserRepository;

import java.util.List;

public class CreateOrderUseCase implements CreateOrderInputPort {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderItemCommandMapper orderItemCommandMapper;
    private final OrderResultMapper orderResultMapper;

    public CreateOrderUseCase(
            OrderRepository orderRepository,
            UserRepository userRepository,
            OrderItemCommandMapper orderItemCommandMapper,
            OrderResultMapper orderResultMapper
    ) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderItemCommandMapper = orderItemCommandMapper;
        this.orderResultMapper = orderResultMapper;
    }

    @Override
    public OrderResult createOrder(CreateOrderCommand command) {
        if (!userRepository.existsById(command.userId())) {
            throw new NotFoundException(
                    UserApplicationErrorCode.USER_NOT_FOUND,
                    "User with id " + command.userId() + " not found"
            );
        }

        List<OrderItem> orderItems = command.orderItems()
                .stream()
                .map(orderItemCommandMapper::mapCreateOrderItemCommandToOrderItem)
                .toList();

        Order order = Order.create(command.userId(), orderItems);

        // lưu xuống database
        Order createdOrder = orderRepository.create(order);
        return orderResultMapper.mapOrderToOrderResult(createdOrder);
    }
}
