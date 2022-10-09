package com.howtodoinjava.spring.boot.rest.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.howtodoinjava.spring.boot.rest.dto.ApiErrorDTO;
import com.howtodoinjava.spring.boot.rest.exception.NoRecordException;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(NoRecordException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiErrorDTO handleValidationError(NoRecordException ex) {
 
		return new ApiErrorDTO("NOT_FOUND", "No Record Found!");
	}
}