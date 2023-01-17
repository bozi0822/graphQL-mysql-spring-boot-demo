//package com.example.demo.controller;
//
//import com.example.demo.entity.Employee;
//import com.example.demo.service.EmployeeService;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@RequestMapping("employee")
//public class EmployeeController {
//
//	@Resource
//	private EmployeeService employeeService;
//
//	@RequestMapping("testFindAll")
//	public String testFindAll(){
//		List<Employee> all = employeeService.findAll(null);
//
//		return Arrays.toString(all.toArray());
//	}
//}
