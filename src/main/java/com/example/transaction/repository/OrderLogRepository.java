package com.example.transaction.repository;

import com.example.transaction.entity.OrderLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Alexander Choi
 * @date : 2022/03/22
 */
@Repository
public interface OrderLogRepository extends JpaRepository<OrderLog, Long> {
}
