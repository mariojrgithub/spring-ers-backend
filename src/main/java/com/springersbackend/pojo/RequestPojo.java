package com.springersbackend.pojo;

import java.sql.Timestamp;

public class RequestPojo {

	private int expenseId;
	private long expenseAmount;
	private int employeeId;
	private Timestamp requestDate;
	private String expenseStatus;
	private Timestamp adjudicatedDate;
	private String approveDeny;

	public RequestPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestPojo(int expenseId, long expenseAmount, int employeeId, Timestamp requestDate, String expenseStatus,
			Timestamp adjudicatedDate, String approveDeny) {
		super();
		this.expenseId = expenseId;
		this.expenseAmount = expenseAmount;
		this.employeeId = employeeId;
		this.requestDate = requestDate;
		this.expenseStatus = expenseStatus;
		this.adjudicatedDate = adjudicatedDate;
		this.approveDeny = approveDeny;
	}

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public long getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(long expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Timestamp getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}

	public String getExpenseStatus() {
		return expenseStatus;
	}

	public void setExpenseStatus(String expenseStatus) {
		this.expenseStatus = expenseStatus;
	}

	public Timestamp getAdjudicatedDate() {
		return adjudicatedDate;
	}

	public void setAdjudicatedDate(Timestamp adjudicatedDate) {
		this.adjudicatedDate = adjudicatedDate;
	}

	public String getApproveDeny() {
		return approveDeny;
	}

	public void setApproveDeny(String approveDeny) {
		this.approveDeny = approveDeny;
	}

	@Override
	public String toString() {
		return "RequestPojo [expenseId=" + expenseId + ", expenseAmount=" + expenseAmount + ", employeeId=" + employeeId
				+ ", requestDate=" + requestDate + ", expenseStatus=" + expenseStatus + ", adjudicatedDate="
				+ adjudicatedDate + ", approveDeny=" + approveDeny + "]";
	}

}
