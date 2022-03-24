package com.springersbackend.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expense_details")
public class RequestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_id", columnDefinition = "serial")
	private int expenseId;

	@Column(name = "expense_amount")
	private long expenseAmount;

	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "request_date")
	private Timestamp requestDate;

	@Column(name = "expense_status")
	private String expenseStatus;

	@Column(name = "adjudicated_date")
	private Timestamp adjudicatedDate;

	@Column(name = "approve_deny")
	private String approveDeny;

	public RequestEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestEntity(int expenseId, long expenseAmount, int employeeId, Timestamp requestDate, String expenseStatus,
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
		return "RequestEntity [expenseId=" + expenseId + ", expenseAmount=" + expenseAmount + ", employeeId="
				+ employeeId + ", requestDate=" + requestDate + ", expenseStatus=" + expenseStatus
				+ ", adjudicatedDate=" + adjudicatedDate + ", approveDeny=" + approveDeny + "]";
	}

}
