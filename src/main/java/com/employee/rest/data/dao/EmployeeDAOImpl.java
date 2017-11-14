/**
 * 
 */
package com.employee.rest.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.rest.data.model.Employee;
import com.employee.rest.exception.EmployeeNotFoundException;

/**
 * EmployeeDAOImpl - Implementing the EmployeeDAO Interface
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger LOGGER = Logger.getLogger(EmployeeDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

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
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.update(employee);
		
		tx.commit();
		session.close();
		return employee;
	}

	public Employee getEmployee(int sapid) throws EmployeeNotFoundException {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, sapid);
		
			if (employee == null) {
				throw new EmployeeNotFoundException(sapid);
			}
			
		tx.commit();
		session.close();
		return employee;

	}

	public boolean isEmployeeExists(Employee employee) {
		return false;
	}

	public boolean removeEmployee(int sapId) throws EmployeeNotFoundException {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Employee employee = getEmployee(sapId);
		session.delete(employee);
		tx.commit();
		session.close();
		return (employee.getSapId() != null);
	}

	public boolean insertEmployee(Employee employee) {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		LOGGER.log(Level.DEBUG, employee.toString());

		session.save(employee);
		
		tx.commit();
		session.close();

		return (employee.getSapId() != null);
	}

	public Employee modifyEmployeeRecord(Employee employee) throws EmployeeNotFoundException {
		// TODO: make changes to the return by removing the throw
		throw new EmployeeNotFoundException(1);
	}

}
