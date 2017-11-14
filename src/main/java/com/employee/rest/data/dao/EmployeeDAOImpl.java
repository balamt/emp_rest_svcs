/**
 * 
 */
package com.employee.rest.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.employee.rest.data.model.Employee;
import com.employee.rest.exception.EmployeeNotFoundException;

/**
 * EmployeeDAOImpl - Implementing the EmployeeDAO Interface
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		Employee vo1 = new Employee();
		vo1.setSapId(1);
		vo1.setFullName("Lokesh");
		vo1.setEmail("Lokesh@test.com");
		vo1.setCity("Chennai");

		employees.add(vo1);

		Employee vo2 = new Employee();
		vo2.setSapId(1);
		vo2.setFullName("Mukesh");
		vo2.setEmail("Mukesh@test.com");
		vo2.setCity("Pune");
		employees.add(vo2);

		return employees;
	}

	public Employee modifyEmployeeDetails(Employee employee) {
		return null;
	}

	public Employee getEmployee(int sapid) throws EmployeeNotFoundException {
		// TODO: make changes to the return by removing the throw
		throw new EmployeeNotFoundException(1);
	}

	public boolean isEmployeeExists(Employee employee) {
		return false;
	}

	public boolean removeEmployee(Employee employee) {
		return false;
	}

	public Employee insertEmployee(Employee employee) {
		return null;
	}

	public Employee modifyEmployeeRecord(Employee employee) throws EmployeeNotFoundException {
		// TODO: make changes to the return by removing the throw
		throw new EmployeeNotFoundException(1);
	}

}
