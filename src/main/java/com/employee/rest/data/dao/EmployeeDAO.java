/**
 * 
 */
package com.employee.rest.data.dao;

import java.util.List;

import com.employee.rest.data.model.Employee;
import com.employee.rest.exception.EmployeeNotFoundException;

/**
 * Employee Interface
 *
 */
public interface EmployeeDAO {

	// INSERT - CREATE
	Employee insertEmployee(Employee employee);

	// UPDATE
	Employee modifyEmployeeDetails(Employee employee);

	// SELECT - RETRIEVE
	List<Employee> getAllEmployees();

	Employee getEmployee(int sapid) throws EmployeeNotFoundException;

	boolean isEmployeeExists(Employee employee);

	// DELETE
	boolean removeEmployee(Employee employee);

	Employee modifyEmployeeRecord(Employee employee) throws EmployeeNotFoundException;

	

}
