package ru.job4j.kitchen.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.kitchen.model.Order;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrderRepository {

    private final List<Order> orders;
    private static int id = 1;

    public Order save(Order order) {
        order.setId(id++);
        orders.add(order);
        return order;
    }

}
