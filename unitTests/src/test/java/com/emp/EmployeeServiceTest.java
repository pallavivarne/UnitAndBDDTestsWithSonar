package com.emp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.emp.service.EmployeeService;

public class EmployeeServiceTest {
	
	@Test
	public void validateSalaryTest() throws Exception {
		EmployeeService employeeService = new EmployeeService(null);
		assertEquals("15000", employeeService.validateSalary(12000).toString());
		assertEquals("25000", employeeService.validateSalary(25000).toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validateSalaryExeptionTest() throws Exception {
		EmployeeService employeeService = new EmployeeService(null);
		employeeService.validateSalary(9000);
	}
	
}
