/**
 * 
 */
package com.employee.rest.service;

import java.util.List;

import com.employee.rest.data.model.Employee;
import com.employee.rest.exception.EmployeeDataIntegrityException;
import com.employee.rest.exception.EmployeeNotFoundException;

/**
 * EmployeeService Service Interface
 *
 */
public interface EmployeeService {

	List<Employee> listAll();

	Employee getEmployeeDetails(int sapid) throws EmployeeNotFoundException;

	boolean addEmployee(Employee employee);

	Employee modifyEmployeeDetails(Employee employee) throws EmployeeNotFoundException, EmployeeDataIntegrityException;

	boolean removeEmployeeDetails(int sapid) throws EmployeeNotFoundException;

}
