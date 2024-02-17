package ru.job4j.kitchen.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.kitchen.model.Order;

/**
 * Класс KitchenService получает сообщение из очереди
 * Метод с аннотацией @KafkaListener будет вызван как только придёт сообщение в очередь orders
 */
@Service
@Slf4j
public class KitchenService {

    @KafkaListener(topics = "orders")
    public void receiveOrder(Order order) {
        log.debug(order.toString());
    }
}
