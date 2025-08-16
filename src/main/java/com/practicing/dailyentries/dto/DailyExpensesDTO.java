package com.practicing.dailyentries.dto;

import com.practicing.dailyentries.entities.DailyExpenses;

public class DailyExpensesDTO {
	
	private Long id;
	private String name;
	private String description;
	private Double amount;
	private String status;
	private String date;
	private Long user;	
	private Long category;	
	
	public DailyExpensesDTO() {
	}

	public DailyExpensesDTO(Long id, String name, String description, Double amount, String status, String date,
			Long user, Long category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.date = date;
		this.user = user;
		this.category = category;
	}
	
	public DailyExpensesDTO(DailyExpenses entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		amount = entity.getAmount();
		status = entity.getStatus().name();
		date = entity.getDate().toString();
		user = entity.getUser().getId();
		category = entity.getCategory().getId();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getAmount() {
		return amount;
	}

	public String getStatus() {
		return status;
	}

	public String getDate() {
		return date;
	}

	public Long getUser() {
		return user;
	}

	public Long getCategory() {
		return category;
	}
}
