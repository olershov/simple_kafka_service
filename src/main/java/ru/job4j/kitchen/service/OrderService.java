package ru.job4j.kitchen.service;

import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.kitchen.model.Order;
import ru.job4j.kitchen.repository.OrderRepository;

/**
 * Класс OrderService сохраняет заказ, а затем с помощью класса KafkaTemplate отправляет сообщение в очередь
 * Первый параметр метода send - имя очереди, второй - объект передачи
 */

@Service
@AllArgsConstructor
public class OrderService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final OrderRepository repository;

    public Order save(Order order) {
        var savedOrder = repository.save(order);
        kafkaTemplate.send("orders", savedOrder);
        return savedOrder;
    }

}
