package com.example.OrderService.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.OrderService.RestaurantClient;
import com.example.OrderService.Order.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private RestaurantClient restaurantClient;

    List<Order> orders = new ArrayList<>();

    @PostMapping
    public Order createOrder(@RequestBody Order order) {

        

        if (restaurantClient.getRestaurantById(order.getRestaurantId()) == null) {
            throw new RuntimeException("Restaurant not found");
        }
        

        orders.add(order);
        return order;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orders;
    }
}
