package com.example.transaction;

import com.example.transaction.entity.OrderInfo;
import com.example.transaction.entity.OrderLog;
import com.example.transaction.repository.OrderLogRepository;
import com.example.transaction.repository.OrderRepository;
import com.example.transaction.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Alexander Choi
 * @date : 2022/03/22
 */
@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderLogRepository orderLogRepository;

    @Test
    public void rollbackTest() throws Exception {
        Assertions.assertThrows(RuntimeException.class, () -> {
            orderService.createOrder();
        });

        List<OrderInfo> orders = orderRepository.findAll();
        List<OrderLog> orderLogs = orderLogRepository.findAll();

        for (OrderLog orderLog : orderLogs) {
            System.out.println("orderLog = " + orderLog);
        }

        assertEquals(0, orders.size());
        assertEquals(1, orderLogs.size());
    }

}

