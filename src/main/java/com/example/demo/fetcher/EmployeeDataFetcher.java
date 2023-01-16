package com.example.demo.fetcher;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class EmployeeDataFetcher {


	@Resource
	private EmployeeService employeeService;

	@DgsQuery
	public List<Employee> employees(@InputArgument String nameFilter) {
		List<Employee> employees = employeeService.findAll();

		if(nameFilter == null) {
			return employees;
		}

		return employees.stream().filter(s -> s.getName().contains(nameFilter)).collect(Collectors.toList());
	}


}
