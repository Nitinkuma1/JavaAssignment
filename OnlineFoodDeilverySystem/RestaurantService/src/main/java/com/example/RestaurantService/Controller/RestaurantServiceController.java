package com.example.RestaurantService.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestaurantService.Model.Restaurant;

@RestController
@RequestMapping("/restaurants")
public class RestaurantServiceController {
	ArrayList<Restaurant> restaurants = new ArrayList<>();

    @GetMapping
    public ArrayList<Restaurant> getAllRestaurants() {
        return restaurants;
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable int id) {

        return restaurants.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        restaurants.add(restaurant);
        return restaurant;
    }

}
