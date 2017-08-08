package com.emp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import com.emp.base.BaseService;
import com.emp.model.Employee;

public class BaseServiceTest extends TestCase {
	
	 private static Employee emp1;
	 private static Employee emp2;
	 private static BaseService<Employee,Integer> baseService;
	 
		@SuppressWarnings("unchecked")
		@BeforeClass
		public void setUp() throws Exception{
	    	emp1 = new Employee(101, "Pallavi","Pune", "1001", 30000);
	    	emp2 = new Employee(102, "Pallavi1","Pune1", "1002", 45000);
	    	baseService = mock(BaseService.class);
	    	when(baseService.create(emp1)).thenReturn(emp1);
	    	when(baseService.readAll()).thenReturn(Arrays.asList(emp1,emp2));
	    	when(baseService.findById(101)).thenReturn(emp1);
	    	when(baseService.update(emp1)).thenReturn(emp1);
	    	when(baseService.delete(101)).thenReturn(HttpStatus.OK);
		}
	    
		@Test
		public void testCreate()
		{
			Employee emp1Obj = (Employee) baseService.create(emp1);
		    assertNotNull(emp1Obj.getId());
		    assertEquals("101",emp1Obj.getId().toString());
		    assertEquals("Pallavi",emp1Obj.getName().toString());
		    assertEquals("Pune",emp1Obj.getAddress().toString());
		    assertEquals("1001",emp1Obj.getDeptId().toString());
		    assertEquals(String.valueOf(30000),emp1Obj.getSalary().toString());
		}
		
		@Test
		public void testFindById() throws Exception
		{
		 	int id = 101;
		 	Employee emp1 = (Employee) baseService.findById(id);
		    assertNotNull(emp1);
		    assertEquals(emp1.getId().toString(), "101");
		}
		
		@Test
		public void testReadAll()
		{
		 	List<Employee> empList = baseService.readAll();
		    assertNotNull(empList);
		    assertEquals(2, empList.size());
		    Employee emp1Obj = empList.get(0);
		    assertEquals("101", emp1Obj.getId().toString());
		}
		
		@Test
		public void testUpdate() 
		{
			Employee emp1Obj = (Employee) baseService.update(emp1);
		    assertNotNull(emp1Obj.getId());
		    assertEquals("101",emp1Obj.getId().toString());
		}
		
		@Test
		public void testDelete() 
		{
			HttpStatus deleted  = baseService.delete(101);
		    assertEquals(HttpStatus.OK, deleted);
		}
		
}
