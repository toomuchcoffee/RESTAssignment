package de.smava.assignment.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid parameters") 
public class ServiceException extends RuntimeException {

}
