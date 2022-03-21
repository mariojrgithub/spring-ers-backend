package com.springersbackend.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springersbackend.entity.EmployeeEntity;
import com.springersbackend.pojo.EmployeePojo;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {

	// select * from employee_details where employee_email = "mario@gmail.com"
	Optional<EmployeeEntity> findByEmployeeEmail(String employeeEmail);

	// select * from employee_details where employee_email = "" AND
	// employee_password = "" AND employee_role = ""
//	Optional<EmployeeEntity> findByEmployeeEmailAndEmployeePasswordAndEmployeeRole(EmployeePojo employeePojo);

}
