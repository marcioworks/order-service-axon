package com.example.orderService.command.event;

import com.example.orderService.enums.OrderStatus;
import lombok.Data;

@Data
public class OrderCreateEvent {

    private String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private String addressId;
    private OrderStatus orderStatus;
}
