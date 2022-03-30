package com.baraka.exceptions;

import com.baraka.constants.Constant;
import com.baraka.dto.ErrorResponseDto;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Optional;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ JdbcSQLIntegrityConstraintViolationException.class })
    public ResponseEntity<Object> handleJdbcSQLIntegrityConstraintViolationException(final JdbcSQLIntegrityConstraintViolationException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error("Exception :", ex);
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .status(HttpStatus.NOT_ACCEPTABLE)
                .message(Constant.ERROR_MESSAGES.UNIQUE_BREACH).build();
        return new ResponseEntity<>(errorResponseDto, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({ InsufficientFundException.class })
    public ResponseEntity<Object> handleJdbcSQLIntegrityConstraintViolationException(final InsufficientFundException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error("Exception :", ex);
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .status(HttpStatus.NOT_ACCEPTABLE)
                .message(Constant.ERROR_MESSAGES.INSUFFICIENT_BALANCE).build();
        return new ResponseEntity<>(errorResponseDto, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({ RecordNotFoundException.class })
    public ResponseEntity<Object> handleJdbcSQLIntegrityConstraintViolationException(final RecordNotFoundException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error("Exception :", ex);
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(Constant.ERROR_MESSAGES.RECORD_NOT_FOUND).build();
        return new ResponseEntity<>(errorResponseDto, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ InvalidRequestException.class })
    public ResponseEntity<Object> handleJdbcSQLIntegrityConstraintViolationException(final InvalidRequestException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error("Exception :", ex);
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(Constant.ERROR_MESSAGES.MANDATORY_FIELDS_MISSING)
                .missingFields(ex.getErrors().getErrors()).build();
        return new ResponseEntity<>(errorResponseDto, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
