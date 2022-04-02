package com.example.transaction.service;

import com.example.transaction.exception.PgException;
import org.springframework.stereotype.Service;

/**
 * @author : Alexander Choi
 * @date : 2022/04/02
 */
@Service
public class PgService {

    public void requestPg() {
        throw new PgException("잔액이 부족하여 결제 실패하였습니다.");
    }

}
