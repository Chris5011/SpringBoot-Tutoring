package dev.chris5011.projects.springexampleproject.exception;

public class CustomerNotOldEnoughException extends RuntimeException {
    public CustomerNotOldEnoughException() { }
    public CustomerNotOldEnoughException(String message) { super(message); }
}
