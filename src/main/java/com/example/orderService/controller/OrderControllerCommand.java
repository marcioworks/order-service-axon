package com.example.orderService.controller;

import com.example.orderService.command.CreateOrderCommand;
import com.example.orderService.command.OrderCommandInput;
import com.example.orderService.enums.OrderStatus;
import com.example.orderService.model.OrderEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderControllerCommand {

    private final CommandGateway commandGateway;

    public OrderControllerCommand(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderCommandInput order){

        CreateOrderCommand createOrderCommand = new CreateOrderCommand(
                UUID.randomUUID().toString(),
                "27b95829-4f3f-4ddf-8983-151ba010e35b",
                order.getProductId(),
                order.getQuantity(),
                order.getAddressId(),
                OrderStatus.CREATED
        );

        String returnValue;
        returnValue = commandGateway.sendAndWait(createOrderCommand);

        return ResponseEntity.ok().body(returnValue);
    }
}
