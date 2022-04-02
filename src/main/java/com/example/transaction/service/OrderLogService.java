package com.example.transaction.service;

import com.example.transaction.entity.OrderLog;
import com.example.transaction.repository.OrderLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Alexander Choi
 * @date : 2022/03/22
 */
@Service
@RequiredArgsConstructor
public class OrderLogService {

    private final OrderLogRepository orderLogRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createOrderFailureLog(String errorMsg) {
        OrderLog newBoardLog = OrderLog.builder()
                .message(errorMsg)
                .build();

        orderLogRepository.save(newBoardLog);
    }

}
