package com.example.transaction.exception;

/**
 * @author : Alexander Choi
 * @date : 2022/04/02
 */
public class PgException extends RuntimeException {

    public PgException() {
        super();
    }

    public PgException(String message) {
        super(message);
    }
}
