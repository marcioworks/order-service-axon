package com.example.orderService.command.aggregate;

import com.example.orderService.command.CreateOrderCommand;
import com.example.orderService.command.event.OrderCreateEvent;
import com.example.orderService.enums.OrderStatus;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private String addressId;
    private OrderStatus orderStatus;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand){
        OrderCreateEvent orderCreateEvent = new OrderCreateEvent();
        BeanUtils.copyProperties(createOrderCommand, orderCreateEvent);
        AggregateLifecycle.apply(orderCreateEvent);
    }

    @EventSourcingHandler
    public void on(OrderCreateEvent orderCreateEvent){
        this.orderId = orderCreateEvent.getOrderId();
        this.productId = orderCreateEvent.getProductId();
        this.userId = orderCreateEvent.getUserId();
        this.quantity = orderCreateEvent.getQuantity();
        this.addressId = orderCreateEvent.getAddressId();
        this.orderStatus = orderCreateEvent.getOrderStatus();
    }
}
