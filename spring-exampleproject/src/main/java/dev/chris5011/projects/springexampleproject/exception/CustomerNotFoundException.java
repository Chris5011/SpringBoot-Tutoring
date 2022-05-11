package dev.chris5011.projects.springexampleproject.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() { }
    public CustomerNotFoundException(String message) { super(message); }
}
