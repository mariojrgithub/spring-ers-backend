package com.springersbackend.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springersbackend.dao.EmployeeDao;
import com.springersbackend.dao.RequestDao;
import com.springersbackend.entity.RequestEntity;
import com.springersbackend.exceptions.SystemException;
import com.springersbackend.pojo.RequestPojo;

@Service
public class RequestServiceImpl implements RequestService {

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
		List<RequestPojo> allRequestsPojo = new ArrayList<RequestPojo>();
		List<RequestEntity> allRequestsEntity = requestDao.findAll();
		for (RequestEntity requestEntity : allRequestsEntity) {
			RequestPojo requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(),
					requestEntity.getEmployeeId(), requestEntity.getRequestDate(), requestEntity.getExpenseStatus(),
					requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
			allRequestsPojo.add(requestPojo);
		}

		return allRequestsPojo;
	}

	@Override
	public List<RequestPojo> fetchPendingRequests() throws SystemException {
		List<RequestEntity> optional = requestDao.findByExpenseStatus("pending");
		List<RequestPojo> allPendingRequestsPojo = new ArrayList<RequestPojo>();

		RequestPojo requestPojo = null;
		for (RequestEntity option: optional) {
//			RequestEntity requestEntity = option.get();
			requestPojo = new RequestPojo(option.getExpenseId(), option.getExpenseAmount(),
					option.getEmployeeId(), option.getRequestDate(), option.getExpenseStatus(),
					option.getAdjudicatedDate(), option.getApproveDeny());

			allPendingRequestsPojo.add(requestPojo);
		}

		return allPendingRequestsPojo;
	}

	@Override
	public List<RequestPojo> fetchResolvedRequests() throws SystemException {
		List<RequestEntity> optional = requestDao.findByExpenseStatus("resolved");
		List<RequestPojo> allResolvedRequestsPojo = new ArrayList<RequestPojo>();

		RequestPojo requestPojo = null;
		for (RequestEntity option: optional) {
//			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(option.getExpenseId(), option.getExpenseAmount(),
					option.getEmployeeId(), option.getRequestDate(), option.getExpenseStatus(),
					option.getAdjudicatedDate(), option.getApproveDeny());

			allResolvedRequestsPojo.add(requestPojo);
		}

		return allResolvedRequestsPojo;
	}

	@Override
	public List<RequestPojo> fetchEmployeeRequests(int employeeId) throws SystemException {
		List<RequestEntity> optional = requestDao.findAllByEmployeeId(employeeId);
		List<RequestPojo> allEmployeeRequests = new ArrayList<RequestPojo>();

		RequestPojo requestPojo = null;
		for (RequestEntity option: optional) {
//			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(option.getExpenseId(), option.getExpenseAmount(),
					option.getEmployeeId(), option.getRequestDate(), option.getExpenseStatus(),
					option.getAdjudicatedDate(), option.getApproveDeny());

			allEmployeeRequests.add(requestPojo);
		}

		return allEmployeeRequests;
	}

	@Override
	public List<RequestPojo> fetchEmployeePendingRequests(int employeeId) throws SystemException {
		List<RequestEntity> optional = requestDao.findByEmployeeIdAndExpenseStatus(employeeId, "pending");
		List<RequestPojo> allEmployeeRequests = new ArrayList<RequestPojo>();

		RequestPojo requestPojo = null;
		for (RequestEntity option: optional) {
//			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(option.getExpenseId(), option.getExpenseAmount(),
					option.getEmployeeId(), option.getRequestDate(), option.getExpenseStatus(),
					option.getAdjudicatedDate(), option.getApproveDeny());

			allEmployeeRequests.add(requestPojo);
		}

		return allEmployeeRequests;
	}

	@Override
	public List<RequestPojo> fetchEmployeeResolvedRequests(int employeeId) throws SystemException {
		List<RequestEntity> optional = requestDao.findByEmployeeIdAndExpenseStatus(employeeId, "resolved");
		List<RequestPojo> allEmployeeRequests = new ArrayList<RequestPojo>();

		RequestPojo requestPojo = null;
		for (RequestEntity option: optional) {
//			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(option.getExpenseId(), option.getExpenseAmount(),
					option.getEmployeeId(), option.getRequestDate(), option.getExpenseStatus(),
					option.getAdjudicatedDate(), option.getApproveDeny());

			allEmployeeRequests.add(requestPojo);
		}

		return allEmployeeRequests;
	}

	@Override
	public RequestPojo updateRequest(RequestPojo requestPojo) throws SystemException {
		// current time
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		RequestEntity requestEntity = new RequestEntity(requestPojo.getExpenseId(), requestPojo.getExpenseAmount(),
				requestPojo.getEmployeeId(), requestPojo.getRequestDate(), requestPojo.getExpenseStatus(),
				timestamp, requestPojo.getApproveDeny());

		requestDao.save(requestEntity);

		requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(),
				requestEntity.getEmployeeId(), requestEntity.getRequestDate(), requestEntity.getExpenseStatus(),
				requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());

		return requestPojo;
	}

	@Override
	public RequestPojo fetchOneRequest(int requestId) throws SystemException {
		Optional<RequestEntity> optional = requestDao.findById(requestId);
		RequestPojo requestPojo = null;
		if (optional.isPresent()) {
			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(),
					requestEntity.getEmployeeId(), requestEntity.getRequestDate(), requestEntity.getExpenseStatus(),
					requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
		}

		return requestPojo;
	}

}
