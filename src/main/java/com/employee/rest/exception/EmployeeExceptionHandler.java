/**
 * 
 */
package com.employee.rest.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

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
	public String employeeNotFound(int sapid) {
		LOGGER.log(Level.WARNING, sapid + "");
		return "Employee Not Found";
	}

}
