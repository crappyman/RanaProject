package pojo;

import java.sql.Timestamp;

import pojo.enums.Status;


public class Reimbursement {
	private int reimbId;
	private int amount;
	private Timestamp dateSubmitted;
	private Timestamp dateResolved;
	private String description;
	private int author;
	private int resolver;
	// Pending, Approved, Denied
	private Status status;
	
	private String type;
	

	public Reimbursement() {
	}

	public Reimbursement(int reimbId, int author, int amount, Timestamp dateSubmitted, Timestamp dateResolved, String description,
			int resolver, Status status, String type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.dateSubmitted = dateSubmitted;
		this.dateResolved = dateResolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;

	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Timestamp dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Timestamp getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Timestamp dateResolved) {
		this.dateResolved = dateResolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



}
