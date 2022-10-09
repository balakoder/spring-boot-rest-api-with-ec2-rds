package com.howtodoinjava.spring.boot.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiErrorDTO {

	private String errorCode;
	private String message;

	public ApiErrorDTO(String errorCode, String message) {
	        super();
	        this.errorCode = errorCode;
	        this.message = message;
	}	    }