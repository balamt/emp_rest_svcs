/**
 * 
 */
package com.employee.rest.service;

import java.util.List;

import com.employee.rest.data.model.Employee;
import com.employee.rest.exception.EmployeeNotFoundException;

/**
 * EmployeeManager Service Interface
 *
 */
public interface EmployeeManager {

	List<Employee> listAll();

	Employee getEmployeeDetails(int sapid) throws EmployeeNotFoundException;

	boolean addEmployee(Employee employee);

	Employee modifyEmployeeDetails(Employee employee) throws EmployeeNotFoundException;

	boolean removeEmployeeDetails(int sapid) throws EmployeeNotFoundException;

}
