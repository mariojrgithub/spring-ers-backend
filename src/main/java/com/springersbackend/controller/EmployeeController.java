package com.springersbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springersbackend.exceptions.SystemException;
import com.springersbackend.pojo.EmployeePojo;
import com.springersbackend.pojo.RequestPojo;
import com.springersbackend.service.EmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// http://localhost:4444/api/manager/all-employees
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("manager/all-employees")
	List<EmployeePojo> fetchAllEmployees() throws SystemException {
		return employeeService.fetchAllEmployees();
	}

	// http:localhost:4444/api/associate/requests/add
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("associate/requests/add")
	RequestPojo createNewRequest(@RequestBody RequestPojo requestPojo) throws SystemException {
		return employeeService.createNewRequest(requestPojo);
	}
	
	// http://localhost:4444/api/login
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("login")
	EmployeePojo loginEmployee(@RequestBody EmployeePojo employeePojo) throws SystemException {
		return employeeService.loginEmployee(employeePojo);
	}

}
