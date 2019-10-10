package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer empId;
	@Column
	@NotEmpty(message="Name can not be empty")
	private String empName;
	@Column
//	@NotBlank(message="salary can not be null")
	@NotNull(message="salary can not be null")
	private double salary;
	@Column
	@NotEmpty(message="email can not be empty")
	@Email
	private String email;
	public Employee() {
		super();
	}
	
	public Employee(Integer empId, String empName, double salary, String email) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.email = email;
	}

	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", email=" + email + "]";
	}

	
}
