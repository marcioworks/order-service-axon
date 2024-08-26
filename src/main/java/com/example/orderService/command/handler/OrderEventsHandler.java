package com.example.orderService.command.handler;

import com.example.orderService.command.event.OrderCreateEvent;
import com.example.orderService.model.OrderEntity;
import com.example.orderService.repository.OrderRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderEventsHandler {

    @Autowired
    private OrderRepository orderRepository;

    @EventHandler
    public void on(OrderCreateEvent orderCreateEvent){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderCreateEvent.getOrderId());
        orderEntity.setQuantity(orderCreateEvent.getQuantity());
        orderEntity.setOrderStatus(orderCreateEvent.getOrderStatus());
        orderEntity.setProductId(orderCreateEvent.getProductId());
        orderEntity.setAddressId(orderCreateEvent.getAddressId());
        orderEntity.setOrderStatus(orderCreateEvent.getOrderStatus());
        orderEntity.setUserId(orderCreateEvent.getUserId());

        orderRepository.save(orderEntity);
    }
}
