/**
 * 
 */
package com.employee.rest.data.dao;

import java.util.List;

import com.employee.rest.data.model.Employee;

/**
 * Employee Interface
 *
 */
public interface EmployeeDAO {

	// INSERT - CREATE
	Employee addEmployee(Employee employee);

	// UPDATE
	Employee modifyEmployeeDetails(Employee employee);

	// SELECT - RETRIEVE
	List<Employee> getAllEmployees();

	List<Employee> getEmployee(int sapid);

	boolean isEmployeeExists(Employee employee);

	// DELETE
	boolean removeEmployee(Employee employee);

}
