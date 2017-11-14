/**
 * 
 */
package com.employee.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.rest.data.dao.EmployeeDAO;
import com.employee.rest.data.model.Employee;
import com.employee.rest.exception.EmployeeNotFoundException;

/**
 * EmployeeManager - Extending from the EmployeeDAOImpl
 *
 */
@Service
public class EmployeeManagerImpl implements EmployeeManager {

	@Autowired
	EmployeeDAO employeeDao;

	public List<Employee> listAll() {
		return employeeDao.getAllEmployees();
	}

	public Employee getEmployeeDetails(int sapid) throws EmployeeNotFoundException {
		return employeeDao.getEmployee(sapid);
	}

	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.insertEmployee(employee);
	}

	public Employee modifyEmployeeDetails(Employee employee) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return employeeDao.modifyEmployeeDetails(employee);
	}

	public boolean removeEmployeeDetails(int sapId) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return employeeDao.removeEmployee(sapId);
	}

}
