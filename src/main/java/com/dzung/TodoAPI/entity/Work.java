package com.dzung.TodoAPI.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="WORK")
public class Work {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="START_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	private Date startDate;
	
	@Column(name="END_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	private Date endDate;
	
	@Column(name="STATUS")
	private int status;
	
	public static final int STATUS_DOING = 0;
	public static final int STATUS_PLANNING = 1;
	public static final int STATUS_COMPLETED = 2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

	
}