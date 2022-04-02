package com.example.transaction.service;

import com.example.transaction.entity.OrderInfo;
import com.example.transaction.repository.OrderRepository;
import com.example.transaction.exception.PgException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Alexander Choi
 * @date : 2022/03/22
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderLogService orderLogService;
    private final PgService pgService;

    /**
     *
     * @throws PgException PG 요청 중 실패되면 해당 Exception이 발생합니다.
     * */
    @Transactional
    public void createOrder() {

        try {
            OrderInfo newOrder = OrderInfo.createNewOrder("M1 맥북프로 14인치", 2690000);

            orderRepository.save(newOrder);
            // PG 요청 시도
            pgService.requestPg();

        } catch (PgException pe) {
            orderLogService.createOrderFailureLog(pe.getMessage());
            throw new RuntimeException(pe.getMessage());
        }
    }
}
