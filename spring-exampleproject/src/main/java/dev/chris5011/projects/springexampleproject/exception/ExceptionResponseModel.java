package dev.chris5011.projects.springexampleproject.exception;

import java.time.LocalDateTime;

public class ExceptionResponseModel {

    private String message;
    private String detail;
    private LocalDateTime timestamp;
    private Class exceptionClass;

    public ExceptionResponseModel() {
    }

    public ExceptionResponseModel(String message, String detail, Class exceptionClass) {
        this.message = message;
        this.detail = detail;
        this.timestamp = LocalDateTime.now();
        this.exceptionClass = exceptionClass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Class getExceptionClass() {
        return exceptionClass;
    }

    public void setExceptionClass(Class exceptionClass) {
        this.exceptionClass = exceptionClass;
    }
}
