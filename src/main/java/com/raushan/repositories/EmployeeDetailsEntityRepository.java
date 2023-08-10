package com.raushan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.raushan.data.model.EmployeeDeatils;

//@Repository
public interface EmployeeDetailsEntityRepository extends JpaRepository<EmployeeDeatils, Integer>{

	//List<EmployeeDeatils> findAll();

}
