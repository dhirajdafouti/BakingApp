package com.hellofresh.task1.model.Exception;

public class MenuCardException extends Exception {

    private static final long serialVersionUID = 7718828512143293558L;

    private final int code;


    public MenuCardException(String message, int code) {
        super(message);
        this.code = code;
    }


    public int getCode() {
        return this.code;
    }
}