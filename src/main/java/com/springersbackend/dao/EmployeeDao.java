package com.springersbackend.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springersbackend.entity.EmployeeEntity;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {

	// select * from employee_details where employee_email = "" AND
	// employee_password = "" AND employee_role = ""
	Optional<EmployeeEntity> findByEmployeeEmailAndEmployeePasswordAndEmployeeRole(String employeeEmail,
			String employeePassword, String employeeRole);

}
