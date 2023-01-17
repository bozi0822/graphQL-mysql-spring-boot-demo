package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeMapper employeeMapper;

	public List<Employee> findAll(Employee employee){
		return employeeMapper.findAll(employee);
	}

	public Boolean insert(Employee employee){
		return employeeMapper.insert(employee);
	}
}
