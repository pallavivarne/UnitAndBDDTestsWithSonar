package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

	@Autowired
	EmployeeService employeeSrvc;
	String temp;
	
	@RequestMapping(method = RequestMethod.POST)
	public Employee create(@RequestBody Employee inputentity) {
		return employeeSrvc.createEmp(inputentity);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Employee update(@RequestBody Employee inputentity, @PathVariable(value = "id") Integer id) {
		return employeeSrvc.updateEmp(inputentity,id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Employee findById(@PathVariable(value = "id") Integer id) {
		Employee employee = employeeSrvc.findById(id);
		return employee;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> readAll() {
		return employeeSrvc.readAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable(value = "id") Integer id) {
		return employeeSrvc.delete(id);
	}
	
}