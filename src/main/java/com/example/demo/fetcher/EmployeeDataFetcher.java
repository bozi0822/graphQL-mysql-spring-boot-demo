package com.example.demo.fetcher;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeInput;
import com.example.demo.result.RespCodeEnum;
import com.example.demo.result.Result;
import com.example.demo.service.EmployeeService;
import com.netflix.graphql.dgs.*;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class EmployeeDataFetcher {


	@Resource
	private EmployeeService employeeService;

	@DgsQuery
	public List<Employee> employees(@InputArgument String nameFilter) {
//		Result<List<Employee>> result = new Result<>(RespCodeEnum.SUCCESS);
		List<Employee> employees = employeeService.findAll();

		if (nameFilter == null) {
//			result.setData();
			return employees;
		}

		employees = employees.stream().filter(s -> s.getName().contains(nameFilter)).collect(Collectors.toList());
//		result.setData(employees);
		return employees;
	}

	@DgsMutation
	public Result<Void> addEmployee(@InputArgument EmployeeInput employeeInput) {
		Result<Void> result = new Result<>(RespCodeEnum.SUCCESS);

		int id = employeeInput.getId();
		if (id < 1) {
			throw new IllegalArgumentException("id must be larger than zero");
		}

		Employee employee = new Employee();
		employee.setId(employeeInput.getId());
		employee.setPhone(employeeInput.getPhone());
		employee.setName(employeeInput.getName());
		employee.setEmail(employeeInput.getEmail());
		Boolean insert = employeeService.insert(employee);
		if (!insert) {
			result = new Result<>(RespCodeEnum.FAIL);
		}
		return result;
	}

}
