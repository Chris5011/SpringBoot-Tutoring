package dev.chris5011.projects.springexampleproject.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() { }
    public ProductNotFoundException(String message) { super(message); }
}
