package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private Integer id;

	private String name;

	private String email;

	private String phone;

	private Integer workAge;

	private Date beginDate;

	public void convert(EmployeeInput employeeInput){
		this.setId(employeeInput.getId());
		this.setPhone(employeeInput.getPhone());
		this.setName(employeeInput.getName());
		this.setEmail(employeeInput.getEmail());
		this.setBeginDate(employeeInput.getBeginDate());
		this.setWorkAge(employeeInput.getWorkAge());
	}

}
