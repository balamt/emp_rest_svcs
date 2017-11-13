/**
 * 
 */
package com.employee.rest.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.employee.rest.data.model.Employee;

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

	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee modifyEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getEmployee(int sapid) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmployeeExists(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}
