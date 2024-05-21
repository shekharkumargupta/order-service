package com.skcodify.orderservice.services;

import com.github.javafaker.Faker;
import com.skcodify.orderservice.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private Map<String, Order> orders;

    public OrderServiceImpl(){
        orders = new HashMap<>();
        Faker faker = new Faker();
        for (int i = 0; i < 30; i++) {
            Order order = new Order();
            order.setId(faker.idNumber().valid());
            order.setProductName(faker.book().title());
            order.setUserName(faker.name().username());
            orders.put(order.getId(), order);
        }
    }

    @Override
    public List<Order> findAll() {
        return orders.values().stream().collect(Collectors.toList());
    }

    @Override
    public Order findById(String id) {
        return orders.get(id);
    }

    @Override
    public Order create(Order order) {
        Faker faker = new Faker();
        order.setId(faker.idNumber().valid());
        return orders.put(order.getId(), order);
    }

    @Override
    public Order remove(String id) {
        return orders.remove(id);
    }
}
