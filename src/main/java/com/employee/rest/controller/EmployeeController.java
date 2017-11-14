/**
 * 
 */
package com.employee.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.rest.data.model.Employee;
import com.employee.rest.exception.EmployeeNotFoundException;
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

	/**
	 * getEmployee - URL Mapping <<servlet-mapping>>/employee/{sapid}
	 * 
	 * @return String - Retrieve the employee details for the sapid passed in the
	 *         path.
	 * @throws EmployeeNotFoundException
	 */
	@RequestMapping(value = "/{sapid}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable int sapid) throws EmployeeNotFoundException {
		return empManager.getEmployeeDetails(sapid);
	}

	/**
	 * addEmployee - URL Mapping <<servlet-mapping>>/employee/add
	 * 
	 * @return String - Adding New Employee to the DB
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean addEmployee(@RequestBody Employee employee) {
		return empManager.addEmployee(employee);
	}

	/**
	 * addEmployee - URL Mapping <<servlet-mapping>>/employee/add
	 * 
	 * @return String - Adding New Employee to the DB
	 * @throws EmployeeNotFoundException
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Employee modifyEmployeeDetails(@RequestBody Employee employee) throws EmployeeNotFoundException {
		return empManager.modifyEmployeeDetails(employee);
	}

	/**
	 * addEmployee - URL Mapping <<servlet-mapping>>/employee/delete/{sapid}
	 * 
	 * @return String - Adding New Employee to the DB
	 * @throws EmployeeNotFoundException
	 */
	@RequestMapping(value = "/delete/{sapid}", method = RequestMethod.DELETE)
	public String removeEmployeeDetails(@PathVariable int sapid) throws EmployeeNotFoundException {
		empManager.removeEmployeeDetails(sapid);
		return "Ok";
	}

}
