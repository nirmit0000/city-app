package com.mastercard.errorhandler;

import com.mastercard.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@ControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler({ArgumentNotValidException.class, Exception.class})
    @ResponseBody
    public ResponseEntity<Error> processException(Exception exception) {
        Error error = createError(new Date(), exception.getMessage(), exception.getMessage());
        if (exception instanceof ArgumentNotValidException) {
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Error createError(Date date, String message, String details) {
        Error error = new Error(date, message, details);
        return error;
    }
}
