package com.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@Column
    private String name;
	
	@Column
    private String address;
	
	@Column
    private String deptId;
	
	@Column
    private Integer salary;
	
	public Employee() {}
	
    public Employee(Integer id, String name,String address, String deptId, Integer salary) {
    	this.id = id;
        this.name = name;
        this.address = address;
        this.deptId = deptId;
        this.salary = salary;
    }
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String dept) {
		this.deptId = dept;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
    
}
