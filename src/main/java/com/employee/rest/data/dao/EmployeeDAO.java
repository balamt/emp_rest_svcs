/**
 * 
 */
package com.employee.rest.data.dao;

import java.util.List;

import com.employee.rest.data.model.Employee;
import com.employee.rest.exception.EmployeeDataIntegrityException;
import com.employee.rest.exception.EmployeeNotFoundException;

/**
 * Employee Interface
 *
 */
public interface EmployeeDAO {

	// INSERT - CREATE
	boolean insertEmployee(Employee employee);

	// UPDATE
	Employee modifyEmployeeDetails(Employee employee) throws EmployeeNotFoundException, EmployeeDataIntegrityException;

	// SELECT - RETRIEVE
	List<Employee> getAllEmployees();

	Employee getEmployee(int sapid) throws EmployeeNotFoundException;

	boolean isEmployeeExists(Employee employee) throws EmployeeNotFoundException;

	// DELETE
	boolean removeEmployee(int sapId) throws EmployeeNotFoundException;

}
