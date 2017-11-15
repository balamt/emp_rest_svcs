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
import org.springframework.transaction.annotation.Transactional;

import com.employee.rest.data.model.Employee;
import com.employee.rest.exception.EmployeeDataIntegrityException;
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

	/**
	 * Retrieve all the Records from the DB
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Employee> getAllEmployees() {
		List<Employee> employeesList;
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		employeesList = new ArrayList<Employee>((List<Employee>) session.createCriteria(Employee.class).list());
		return employeesList;
	}

	/**
	 * Modify the Employee Record based on the incoming object. <br/>
	 * This Method Retrieve the record at first and then compares the data
	 * differenced between the objects.
	 * 
	 * @param Employee
	 *            - Object of the employee containing the changes.
	 * @throws EmployeeNotFoundException
	 * @throws EmployeeDataIntegrityException
	 */
	@Transactional
	public Employee modifyEmployeeDetails(Employee employee)
			throws EmployeeNotFoundException, EmployeeDataIntegrityException {

		Employee empDbSource = null;

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		empDbSource = this.getEmployee(employee.getSapId());
		isEmployeeExists(empDbSource);
		
		LOGGER.log(Level.INFO, empDbSource.toString());
		LOGGER.log(Level.INFO, employee.toString());
		
		if (empDbSource.getSapId() <= 0) {
			throw new EmployeeNotFoundException(employee.getSapId());
		}

		if (employee.getCity() != null && (!employee.getCity().equalsIgnoreCase(empDbSource.getCity()))) {
			empDbSource.setCity(employee.getCity());
		}

		if (employee.getEmail() != null && (!employee.getEmail().equalsIgnoreCase(empDbSource.getEmail()))) {
			empDbSource.setEmail(employee.getEmail());
		}

		if (employee.getFullName() != null && (!employee.getFullName().equalsIgnoreCase(empDbSource.getFullName()))) {
			empDbSource.setFullName(employee.getFullName());
		}

		if (employee.getSapId() <= 0 && ((employee.getSapId() != empDbSource.getSapId()))) {
			throw new EmployeeDataIntegrityException("Unable to Edit Sap Id");
		}

		tx.commit();

		return empDbSource;
	}

	@Transactional
	public Employee getEmployee(int sapid) throws EmployeeNotFoundException {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, sapid);

		if (employee == null) {
			throw new EmployeeNotFoundException(sapid);
		}

		return employee;

	}

	public boolean isEmployeeExists(Employee employee) throws EmployeeNotFoundException {

		Employee em = this.getEmployee(employee.getSapId());
		LOGGER.log(Level.DEBUG, em.getSapId());
		return false;
	}

	@Transactional
	public boolean removeEmployee(int sapId) throws EmployeeNotFoundException {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Employee employee = getEmployee(sapId);
		session.delete(employee);
		tx.commit();

		return (employee.getSapId() != null);
	}

	@Transactional
	public boolean insertEmployee(Employee employee) {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		LOGGER.log(Level.DEBUG, employee.toString());

		session.save(employee);

		tx.commit();

		return (employee.getSapId() != null);
	}

	@Transactional
	public Employee modifyEmployeeRecord(Employee employee) throws EmployeeNotFoundException {
		// TODO: make changes to the return by removing the throw
		throw new EmployeeNotFoundException(1);
	}

}
