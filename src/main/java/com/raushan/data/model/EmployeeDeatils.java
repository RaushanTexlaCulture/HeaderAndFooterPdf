package com.raushan.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Emp_dtls")
public class EmployeeDeatils {
	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
	private Integer id;
	
    @Column(name = "EMP_NAME", nullable = false)
	private String name;
	 
    
    @Column(name = "EMP_AGE", nullable = false)
	private Integer age;

    

	public EmployeeDeatils() {
		super();
	}


	public EmployeeDeatils(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}
    
    
    

}
