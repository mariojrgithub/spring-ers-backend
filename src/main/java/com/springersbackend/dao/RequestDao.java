package com.springersbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springersbackend.entity.RequestEntity;


@Repository
public interface RequestDao extends JpaRepository<RequestEntity, Integer> {

	// select * from expense_details where expense_status = "pending"
	List<RequestEntity> findByExpenseStatus(String expenseStatus);

	// fetch employee resolved request
	List<RequestEntity> findByEmployeeIdAndExpenseStatus(int employeeId, String expenseStatus);

	List<RequestEntity> findAllByEmployeeId(int employeeId);


}
