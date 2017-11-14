package com.employee.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * EmployeeNotFoundException - To manage and handle the Employee Not Found in the Record
 *
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee Not Found") 
public class EmployeeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7703318685542070920L;

	
	/**
	 * @param message
	 */
	public EmployeeNotFoundException(int sapid) {
		super(EmployeeNotFoundException.class.getSimpleName() + " with id " + sapid);
	}

}
