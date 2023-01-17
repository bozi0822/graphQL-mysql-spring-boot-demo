package com.example.demo.fetcher;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeInput;
import com.example.demo.result.RespCodeEnum;
import com.example.demo.result.Result;
import com.example.demo.service.EmployeeService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@DgsComponent
public class EmployeeDataFetcher {


	@Resource
	private EmployeeService employeeService;

	@DgsQuery
	public List<Employee> employees(@InputArgument EmployeeInput employeeInput) {

		if (employeeInput == null) {
			return new ArrayList<>(0);
		}

		Employee employee = new Employee();
		employee.convert(employeeInput);

		return employeeService.findAll(employee);

	}

	@DgsMutation
	public Result<Void> addEmployee(@InputArgument EmployeeInput employeeInput) {
		Result<Void> result = new Result<>(RespCodeEnum.SUCCESS);

		Integer id = employeeInput.getId();
		if (id != null && id < 1) {
			throw new IllegalArgumentException("id must be larger than zero");
		}

		Employee employee = new Employee();
		employee.convert(employeeInput);

		Boolean insert = employeeService.insert(employee);
		if (!insert) {
			result = new Result<>(RespCodeEnum.FAIL);
		}
		return result;
	}

}
