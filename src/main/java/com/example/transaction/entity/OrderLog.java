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
public class OrderLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long id;

    private String message;

}
