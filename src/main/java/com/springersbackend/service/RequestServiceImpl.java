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
import com.springersbackend.entity.RequestEntity;
import com.springersbackend.exceptions.SystemException;
import com.springersbackend.pojo.RequestPojo;

@Service
public class RequestServiceImpl implements RequestService {
	
	public static final Logger LOG = LogManager.getLogger(RequestServiceImpl.class);

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	RequestDao requestDao;

	public RequestServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<RequestPojo> fetchAllRequests() throws SystemException {
		LOG.info("Entered fetchAllRequests() in Service");
		
		List<RequestPojo> allRequestsPojo = new ArrayList<RequestPojo>();
		List<RequestEntity> allRequestsEntity = requestDao.findAll();
		for (RequestEntity requestEntity : allRequestsEntity) {
			RequestPojo requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(),
					requestEntity.getEmployeeId(), requestEntity.getRequestDate(), requestEntity.getExpenseStatus(),
					requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
			allRequestsPojo.add(requestPojo);
		}

		LOG.info("Exited fetchAllRequests() in Service");
		
		return allRequestsPojo;
	}

	@Override
	public List<RequestPojo> fetchPendingRequests() throws SystemException {
		LOG.info("Entered fetchPendingRequests() in Service");
		
		List<RequestEntity> optional = requestDao.findByExpenseStatus("pending");
		List<RequestPojo> allPendingRequestsPojo = new ArrayList<RequestPojo>();

		RequestPojo requestPojo = null;
		for (RequestEntity option: optional) {
			requestPojo = new RequestPojo(option.getExpenseId(), option.getExpenseAmount(),
					option.getEmployeeId(), option.getRequestDate(), option.getExpenseStatus(),
					option.getAdjudicatedDate(), option.getApproveDeny());

			allPendingRequestsPojo.add(requestPojo);
		}
		
		LOG.info("Exited fetchPendingRequests() in Service");

		return allPendingRequestsPojo;
	}

	@Override
	public List<RequestPojo> fetchResolvedRequests() throws SystemException {
		LOG.info("Entered fetchResolvedRequests() in Service");
		
		List<RequestEntity> optional = requestDao.findByExpenseStatus("resolved");
		List<RequestPojo> allResolvedRequestsPojo = new ArrayList<RequestPojo>();

		RequestPojo requestPojo = null;
		for (RequestEntity option: optional) {
			requestPojo = new RequestPojo(option.getExpenseId(), option.getExpenseAmount(),
					option.getEmployeeId(), option.getRequestDate(), option.getExpenseStatus(),
					option.getAdjudicatedDate(), option.getApproveDeny());

			allResolvedRequestsPojo.add(requestPojo);
		}

		LOG.info("Exited fetchResolvedRequests() in Service");
		
		return allResolvedRequestsPojo;
	}

	@Override
	public List<RequestPojo> fetchEmployeeRequests(int employeeId) throws SystemException {
		LOG.info("Entered fetchEmployeeRequests() in Service");
		
		List<RequestEntity> optional = requestDao.findAllByEmployeeId(employeeId);
		List<RequestPojo> allEmployeeRequests = new ArrayList<RequestPojo>();

		RequestPojo requestPojo = null;
		for (RequestEntity option: optional) {
			requestPojo = new RequestPojo(option.getExpenseId(), option.getExpenseAmount(),
					option.getEmployeeId(), option.getRequestDate(), option.getExpenseStatus(),
					option.getAdjudicatedDate(), option.getApproveDeny());

			allEmployeeRequests.add(requestPojo);
		}

		LOG.info("Exited fetchEmployeeRequests() in Service");
		
		return allEmployeeRequests;
	}

	@Override
	public List<RequestPojo> fetchEmployeePendingRequests(int employeeId) throws SystemException {
		LOG.info("Entered fetchEmployeePendingRequests() in Service");
		
		List<RequestEntity> optional = requestDao.findByEmployeeIdAndExpenseStatus(employeeId, "pending");
		List<RequestPojo> allEmployeeRequests = new ArrayList<RequestPojo>();

		RequestPojo requestPojo = null;
		for (RequestEntity option: optional) {
			requestPojo = new RequestPojo(option.getExpenseId(), option.getExpenseAmount(),
					option.getEmployeeId(), option.getRequestDate(), option.getExpenseStatus(),
					option.getAdjudicatedDate(), option.getApproveDeny());

			allEmployeeRequests.add(requestPojo);
		}

		LOG.info("Exited fetchEmployeePendingRequests() in Service");
		
		return allEmployeeRequests;
	}

	@Override
	public List<RequestPojo> fetchEmployeeResolvedRequests(int employeeId) throws SystemException {
		LOG.info("Entered fetchEmployeeResolvedRequests() in Service");
		
		List<RequestEntity> optional = requestDao.findByEmployeeIdAndExpenseStatus(employeeId, "resolved");
		List<RequestPojo> allEmployeeRequests = new ArrayList<RequestPojo>();

		RequestPojo requestPojo = null;
		for (RequestEntity option: optional) {
			requestPojo = new RequestPojo(option.getExpenseId(), option.getExpenseAmount(),
					option.getEmployeeId(), option.getRequestDate(), option.getExpenseStatus(),
					option.getAdjudicatedDate(), option.getApproveDeny());

			allEmployeeRequests.add(requestPojo);
		}

		LOG.info("Exited fetchEmployeeResolvedRequests() in Service");
		
		return allEmployeeRequests;
	}

	@Override
	public RequestPojo updateRequest(RequestPojo requestPojo) throws SystemException {
		LOG.info("Entered updateRequest() in Service");
		
		// current time
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		RequestEntity requestEntity = new RequestEntity(requestPojo.getExpenseId(), requestPojo.getExpenseAmount(),
				requestPojo.getEmployeeId(), requestPojo.getRequestDate(), requestPojo.getExpenseStatus(),
				timestamp, requestPojo.getApproveDeny());

		requestDao.save(requestEntity);

		requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(),
				requestEntity.getEmployeeId(), requestEntity.getRequestDate(), requestEntity.getExpenseStatus(),
				requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());

		LOG.info("Exited updateRequest() in Service");
		
		return requestPojo;
	}

	@Override
	public RequestPojo fetchOneRequest(int requestId) throws SystemException {
		LOG.info("Entered fetchOneRequest() in Service");
		
		Optional<RequestEntity> optional = requestDao.findById(requestId);
		RequestPojo requestPojo = null;
		if (optional.isPresent()) {
			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(),
					requestEntity.getEmployeeId(), requestEntity.getRequestDate(), requestEntity.getExpenseStatus(),
					requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
		}

		LOG.info("Exited fetchOneRequest() in Service");
		
		return requestPojo;
	}

}
