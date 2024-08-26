package com.example.orderService.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderCommandInput {

    private String productId;
    private Integer quantity;
    private String addressId;
}
