package com.bridgelabz.addressbookspringapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressBookExceptionHandler {
    @ExceptionHandler(value = AddressBookException.class)
    public ResponseEntity<Object> addressBookExceptionHandler( AddressBookException e){
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
