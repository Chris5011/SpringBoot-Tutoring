package dev.chris5011.projects.springexampleproject.controller;

import dev.chris5011.projects.springexampleproject.exception.CustomerNotFoundException;
import dev.chris5011.projects.springexampleproject.exception.CustomerNotOldEnoughException;
import dev.chris5011.projects.springexampleproject.exception.ExceptionResponseModel;
import dev.chris5011.projects.springexampleproject.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseModel> handleAllExceptions(Exception ex, WebRequest req) {
        ExceptionResponseModel eR = new ExceptionResponseModel(ex.getMessage(), req.getDescription(false), ex.getClass());
        eR.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(eR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Handle IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponseModel> handleUserNotFoundException(IllegalArgumentException ex, WebRequest req) {
        ExceptionResponseModel eR = new ExceptionResponseModel(ex.getMessage(), req.getDescription(false), ex.getClass());
        eR.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(eR, HttpStatus.NOT_ACCEPTABLE);
    }

    //Handle CustomerNotFoundException
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ExceptionResponseModel> handleUserNotFoundException(CustomerNotFoundException ex, WebRequest req) {
        ExceptionResponseModel eR = new ExceptionResponseModel(ex.getMessage(), req.getDescription(false), ex.getClass());
        eR.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(eR, HttpStatus.NOT_FOUND);
    }

    //Handle CustomerNotOldEnoughException
    @ExceptionHandler(CustomerNotOldEnoughException.class)
    public ResponseEntity<ExceptionResponseModel> handleUserNotFoundException(CustomerNotOldEnoughException ex, WebRequest req) {
        ExceptionResponseModel eR = new ExceptionResponseModel(ex.getMessage(), req.getDescription(false), ex.getClass());
        eR.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(eR, HttpStatus.NOT_ACCEPTABLE);
    }

    //Handle ProductNotFoundException
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionResponseModel> handleUserNotFoundException(ProductNotFoundException ex, WebRequest req) {
        ExceptionResponseModel eR = new ExceptionResponseModel(ex.getMessage(), req.getDescription(false), ex.getClass());
        eR.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(eR, HttpStatus.NOT_FOUND);
    }


}
