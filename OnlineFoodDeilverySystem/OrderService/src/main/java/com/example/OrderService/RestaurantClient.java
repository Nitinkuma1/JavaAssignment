package com.example.OrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "RESTAURANTSERVICE")
public interface RestaurantClient {

    @GetMapping("/restaurants/{id}")
    Object getRestaurantById(@PathVariable int id);
}
