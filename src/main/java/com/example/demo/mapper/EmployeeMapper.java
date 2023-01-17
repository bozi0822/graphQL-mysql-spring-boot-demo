package com.example.demo.mapper;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {

	List<Employee> findAll(Employee employee);

	Boolean insert(Employee employee);
}
