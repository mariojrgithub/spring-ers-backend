package com.springersbackend.service;

import java.util.List;

import com.springersbackend.exceptions.SystemException;
import com.springersbackend.pojo.EmployeePojo;
import com.springersbackend.pojo.RequestPojo;



public interface EmployeeService {

	// fetch one employee
	EmployeePojo fetchOneEmployee(String employeeEmail) throws SystemException;

	// fetch one employee by ID
	EmployeePojo fetchOneEmployee(int employeeId) throws SystemException;

	// login
//	EmployeePojo loginEmployee(EmployeePojo employeePojo) throws SystemException;

	// list all employees
	List<EmployeePojo> fetchAllEmployees() throws SystemException;

	// create new request
	RequestPojo createNewRequest(RequestPojo requestPojo) throws SystemException;

}
