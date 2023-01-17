package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
	List<Employee> findAll(Employee employee);

	Boolean insert(Employee employee);
}
