package com.example.transaction.repository;

import com.example.transaction.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Alexander Choi
 * @date : 2022/03/22
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderInfo, Long> {
}
