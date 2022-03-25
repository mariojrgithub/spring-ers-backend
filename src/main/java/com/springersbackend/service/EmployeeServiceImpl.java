package com.springersbackend.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	public static final Logger LOG = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	RequestDao requestDao;

	public EmployeeServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public EmployeePojo fetchOneEmployee(int employeeId) throws SystemException {
		LOG.info("Entered fetchOneEmployee() in Service");
		
		Optional<EmployeeEntity> optional = employeeDao.findById(employeeId);
		EmployeePojo employeePojo = null;
		if (optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(), employeeEntity.getEmployeeRole(),
					employeeEntity.getEmployeeEmail(), employeeEntity.getEmployeePassword(),
					employeeEntity.getEmployeeName());
		}
		
		LOG.info("Exited fetchOneEmployee() in Service");
		
		return employeePojo;
	}

	@Override
	public EmployeePojo loginEmployee(EmployeePojo employeePojo) throws SystemException {
		LOG.info("Entered loginEmployee() in Service");

		Optional<EmployeeEntity> optional = employeeDao.findByEmployeeEmailAndEmployeePasswordAndEmployeeRole(
				employeePojo.getEmployeeEmail(), employeePojo.getEmployeePassword(), employeePojo.getEmployeeRole());

		EmployeePojo employeePojo2 = null;

		if (optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();

			employeePojo2 = new EmployeePojo(employeeEntity.getEmployeeId(), employeeEntity.getEmployeeEmail(),
					employeeEntity.getEmployeePassword(), employeeEntity.getEmployeeRole(),
					employeeEntity.getEmployeeName());

			System.out.println(employeePojo2);
			System.out.println(employeeEntity);
		}
		
		LOG.info("Exited loginEmployee() in Service");
		
		return employeePojo2;
	}

	@Override
	public List<EmployeePojo> fetchAllEmployees() throws SystemException {
		LOG.info("Entered fetchAllEmployees() in Service");
		
		List<EmployeePojo> allEmployeesPojo = new ArrayList<EmployeePojo>();
		List<EmployeeEntity> allEmployeesEntity = employeeDao.findAll();
		for (EmployeeEntity employeeEntity : allEmployeesEntity) {
			EmployeePojo employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(),
					employeeEntity.getEmployeeRole(), employeeEntity.getEmployeeEmail(),
					employeeEntity.getEmployeePassword(), employeeEntity.getEmployeeName());
			allEmployeesPojo.add(employeePojo);
		}
		
		LOG.info("Exited fetchAllEmployees() in Service");

		return allEmployeesPojo;
	}

	@Override
	public RequestPojo createNewRequest(RequestPojo requestPojo) throws SystemException {
		LOG.info("Entered createNewRequest() in Service");
		
		// current time
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		RequestEntity requestEntity = new RequestEntity(requestPojo.getExpenseId(), requestPojo.getExpenseAmount(),
				requestPojo.getEmployeeId(), timestamp, "pending",
				requestPojo.getAdjudicatedDate(), requestPojo.getApproveDeny());

		requestDao.saveAndFlush(requestEntity);

		requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(),
				requestEntity.getEmployeeId(), requestEntity.getRequestDate(), requestEntity.getExpenseStatus(),
				requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());

		LOG.info("Exited createNewRequest() in Service");
		
		return requestPojo;
	}

}
