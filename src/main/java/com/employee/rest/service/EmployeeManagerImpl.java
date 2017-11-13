/**
 * 
 */
package com.employee.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.rest.data.dao.EmployeeDAO;
import com.employee.rest.data.model.Employee;

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

}
