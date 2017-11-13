/**
 * 
 */
package com.employee.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.rest.data.model.Employee;
import com.employee.rest.service.EmployeeManager;

/**
 * EmployeeController - Controller for Employee REST Service API Call
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeManager empManager;

	/**
	 * getAllEmployees - URL Mapping <<servlet-mapping>>/employee/all
	 * 
	 * @return String - Containing the list of employees retrieved
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return empManager.listAll();
	}

}
