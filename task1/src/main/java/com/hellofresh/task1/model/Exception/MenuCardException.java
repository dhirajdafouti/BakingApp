package com.hellofresh.task1.model.Exception;

/**
 * The custom Exception class with the Message and Code.
 * This class will return the error code once any exception occurs.
 */
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