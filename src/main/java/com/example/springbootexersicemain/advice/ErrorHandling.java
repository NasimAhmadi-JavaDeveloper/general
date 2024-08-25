package com.example.springbootexersicemain.advice;

import com.example.springbootexersicemain.exception.*;
import org.hibernate.TransientPropertyValueException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandling {

    @ExceptionHandler(UserNotfoundException.class)
    public ResponseEntity<Object> handleUserNotfoundException() {
        return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UniqueConstraintException.class)
    public ResponseEntity<Object> handleUniqueConstraintException() {
        return new ResponseEntity<>("duplicate key value violates unique constraint", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNullException.class)
    public ResponseEntity<Object> handleUserNullException() {
        return new ResponseEntity<>("user is null", HttpStatus.IM_USED);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException() {
        return new ResponseEntity<>("fk is invalid", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TransientPropertyValueException.class)
    public ResponseEntity<Object> handleTransientPropertyValueException() {
        return new ResponseEntity<>("a Not-null property defined in entity", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException() {
        return new ResponseEntity<>("custom exception", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PostNotfoundException.class)
    public ResponseEntity<Object> handlePostNotfoundException() {
        return new ResponseEntity<>("post not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException() {
        return new ResponseEntity<>("no exist this item in database", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DocumentNotfoundException.class)
    public ResponseEntity<Object> handleDocumentNotfoundException() {
        return new ResponseEntity<>("document not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<Object> handleAuthorNotFoundException() {
        return new ResponseEntity<>("author not found", HttpStatus.NOT_FOUND);
    }
}
