/**
 * 
 */
package com.employee.rest.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * EmployeeExceptionHandler - Handling the Exception Globally
 *
 */
@ControllerAdvice
public class EmployeeExceptionHandler {

	private static final Logger LOGGER = Logger.getLogger(EmployeeExceptionHandler.class.getSimpleName());

	@ExceptionHandler(EmployeeNotFoundException.class)
	public String employeeNotFound(HttpServletRequest req, Exception ex) {
		LOGGER.log(Level.WARNING, ex.getMessage());
		return "Employee Not Found";
	}

}
