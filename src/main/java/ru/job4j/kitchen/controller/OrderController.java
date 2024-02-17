package ru.job4j.kitchen.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.kitchen.model.Order;
import ru.job4j.kitchen.service.OrderService;

@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping("/order")
    public ResponseEntity order(@RequestBody Order order) {
        service.save(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
