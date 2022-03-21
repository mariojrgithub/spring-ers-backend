package com.springersbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springersbackend.dao.EmployeeDao;
import com.springersbackend.dao.RequestDao;
import com.springersbackend.entity.EmployeeEntity;
import com.springersbackend.entity.RequestEntity;
import com.springersbackend.exceptions.SystemException;
import com.springersbackend.pojo.EmployeePojo;
import com.springersbackend.pojo.RequestPojo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	RequestDao requestDao;

	public EmployeeServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public EmployeePojo fetchOneEmployee(String employeeEmail) throws SystemException {
		Optional<EmployeeEntity> optional = employeeDao.findByEmployeeEmail(employeeEmail);
		EmployeePojo employeePojo = null;
		if (optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(), employeeEntity.getEmployeeRole(),
					employeeEntity.getEmployeeEmail(), employeeEntity.getEmployeePassword(),
					employeeEntity.getEmployeeName());
		}

		return employeePojo;
	}

	@Override
	public EmployeePojo fetchOneEmployee(int employeeId) throws SystemException {
		Optional<EmployeeEntity> optional = employeeDao.findById(employeeId);
		EmployeePojo employeePojo = null;
		if (optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(), employeeEntity.getEmployeeRole(),
					employeeEntity.getEmployeeEmail(), employeeEntity.getEmployeePassword(),
					employeeEntity.getEmployeeName());
		}
		return employeePojo;
	}

//	@Override
//	public EmployeePojo loginEmployee(EmployeePojo employeePojo) throws SystemException {
//		Optional<EmployeeEntity> optional = employeeDao
//				.findByEmployeeEmailAndEmployeePasswordAndEmployeeRole(employeePojo);
//		EmployeePojo employeePojo2 = null;
//		if (optional.isPresent()) {
//			EmployeeEntity employeeEntity = optional.get();
//			employeePojo2 = new EmployeePojo(employeeEntity.getEmployeeId(), employeeEntity.getEmployeeRole(),
//					employeeEntity.getEmployeeEmail(), employeeEntity.getEmployeePassword(),
//					employeeEntity.getEmployeeName());
//		}
//		return employeePojo2;
//	}

	@Override
	public List<EmployeePojo> fetchAllEmployees() throws SystemException {
		List<EmployeePojo> allEmployeesPojo = new ArrayList<EmployeePojo>();
		List<EmployeeEntity> allEmployeesEntity = employeeDao.findAll();
		for (EmployeeEntity employeeEntity : allEmployeesEntity) {
			EmployeePojo employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(),
					employeeEntity.getEmployeeRole(), employeeEntity.getEmployeeEmail(),
					employeeEntity.getEmployeePassword(), employeeEntity.getEmployeeName());
			allEmployeesPojo.add(employeePojo);
		}

		return allEmployeesPojo;
	}

	@Override
	public RequestPojo createNewRequest(RequestPojo requestPojo) throws SystemException {
		RequestEntity requestEntity = new RequestEntity(requestPojo.getExpenseId(), requestPojo.getExpenseAmount(),
				requestPojo.getEmployeeId(), requestPojo.getRequestDate(), requestPojo.getExpenseStatus(),
				requestPojo.getAdjudicatedDate(), requestPojo.getApproveDeny());

		requestDao.saveAndFlush(requestEntity);

		requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(),
				requestEntity.getEmployeeId(), requestEntity.getRequestDate(), requestEntity.getExpenseStatus(),
				requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());

		return requestPojo;
	}

}
