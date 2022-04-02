package com.example.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : Alexander Choi
 * @date : 2022/03/22
 */
@Entity
@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private String productName;

    private int price;

    public static OrderInfo createNewOrder(String productName, int price) {
        return OrderInfo.builder()
                .productName(productName)
                .price(price)
                .build();
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
