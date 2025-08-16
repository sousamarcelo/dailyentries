package com.practicing.dailyentries.dto;

import com.practicing.dailyentries.entities.DailyExpenses;
import com.practicing.dailyentries.projection.DailyExpensesDetailsProjection;

public class DailyExpensesProjectionDTO {
	
	private Long id;
	private String Date;
	private String status;
	private String username;
	private String categoryname;
	private String name;
	private Double amount;
	
	public DailyExpensesProjectionDTO() {
	}

	public DailyExpensesProjectionDTO(Long id ,String date, String status, String username, String categoryname, String name,
			Double amount) {
		super();
		this.id = id;
		this.Date = String.valueOf(date);
		this.status = status;
		this.username = username;
		this.categoryname = categoryname;
		this.name = name;
		this.amount = amount;
	}
	
	public DailyExpensesProjectionDTO(DailyExpensesDetailsProjection projection) {
		super();
		id = projection.getId();
		Date = String.valueOf(projection.getDate());
		status = projection.getStatus();
		username = projection.getUsername();
		categoryname = projection.getCategoryname();
		name = projection.getName();
		amount = projection.getAmount();
	}
	
	public DailyExpensesProjectionDTO(DailyExpenses entity) {
		id = entity.getId();
		Date = String.valueOf(entity.getDate());
		status = entity.getStatus().toString();
		username = entity.getUser().getEmail();
		categoryname = entity.getCategory().getName();
		name = entity.getName();
		amount = entity.getAmount();
	}
	
	public Long getId() {
		return id;
	}

	public String getDate() {
		return Date;
	}

	public String getStatus() {
		return status;
	}

	public String getUsername() {
		return username;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public String getName() {
		return name;
	}

	public Double getAmount() {
		return amount;
	}	
}
