package com.emp.repo;


import org.springframework.stereotype.Repository;

import com.emp.base.BaseRepo;
import com.emp.model.Employee;

/**
 * 
 * @author Pallavi Varne
 *
 */
@Repository
public interface EmployeeRepo extends BaseRepo<Employee, Integer> {

}
