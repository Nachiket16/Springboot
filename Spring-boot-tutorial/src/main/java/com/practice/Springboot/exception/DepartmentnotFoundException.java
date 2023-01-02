package com.practice.Springboot.exception;

public class DepartmentnotFoundException extends Exception{
    public DepartmentnotFoundException() {
        super();
    }

    public DepartmentnotFoundException(String message) {
        super(message);
    }

    public DepartmentnotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentnotFoundException(Throwable cause) {
        super(cause);
    }

    protected DepartmentnotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
