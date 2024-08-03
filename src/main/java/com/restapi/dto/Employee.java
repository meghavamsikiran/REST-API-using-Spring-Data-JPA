package com.restapi.dto;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // objects are managed & connected to persistance context related objects
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="emp_id")
	private int empId;
	@Column(name="emp_name")
	private String empName;
	@Column(name = "age")
	private int empAge;
	@Column(name="date_of_join")
	private java.sql.Date dateOfJoin;
	
	public Employee() {
		super();
	}

	public Employee(int empId, String empName, int empAge, Date dateOfJoin) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.dateOfJoin = dateOfJoin;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public java.sql.Date getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(java.sql.Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", dateOfJoin=" + dateOfJoin
				+ "]";
	}
	
}
