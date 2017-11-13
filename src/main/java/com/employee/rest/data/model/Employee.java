/**
 * 
 */
package com.employee.rest.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee Model Class
 *
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = 571491446097074528L;

	@Id
	@Column(name = "sapid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sapId;
	
	private String fullName;
	private String email;
	private String city;

	public String getCity() {
		return city;
	}

	public String getEmail() {
		return email;
	}

	public String getFullName() {
		return fullName;
	}

	public Integer getSapId() {
		return sapId;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setSapId(Integer sapId) {
		this.sapId = sapId;
	}

	@Override
	public String toString() {
		StringBuilder toStringBuilder = new StringBuilder();
		toStringBuilder.append(Employee.class.getSimpleName());
		toStringBuilder.append("[");
		toStringBuilder.append("SAP ID : " + this.sapId);
		toStringBuilder.append(", Name : " + this.fullName);
		toStringBuilder.append(", Email : " + this.email);
		toStringBuilder.append(", City : " + this.city);
		toStringBuilder.append("]");
		return toStringBuilder.toString();

	}

}
