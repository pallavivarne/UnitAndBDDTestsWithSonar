package com.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.base.BaseService;
import com.emp.model.Employee;
import com.emp.repo.EmployeeRepo;

@Service
public class EmployeeService extends BaseService <Employee, Integer>{

	@Autowired
	EmployeeRepo employeeRepo; 
	
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		super(employeeRepo);
		this.employeeRepo = employeeRepo;
	}
	
	public Employee createEmp(Employee inputentity)
	{
		inputentity.setSalary(validateSalary(inputentity.getSalary()));
		return create(inputentity);
	}
	
	public Employee updateEmp(Employee inputentity, Integer id) {
		Employee employee = employeeRepo.findOne(id);
		employee.setName(inputentity.getName());
		employee.setAddress(inputentity.getAddress());
		employee.setDeptId(inputentity.getDeptId());
		employee.setSalary(inputentity.getSalary());
		return update(employee);
	}
	
	public Integer validateSalary(Integer salary) throws IllegalArgumentException {
		int revisedSalary = salary;
		if(revisedSalary<10000)
			throw new IllegalArgumentException("Salary should not be less than 10000");
		else if(revisedSalary<15000)
			revisedSalary=15000;
		return revisedSalary;
	}
	
}
