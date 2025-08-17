package com.practicing.dailyentries.dto;

import com.practicing.dailyentries.entities.DailyExpenses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class DailyExpensesDTO {
	
	private Long id;
	
	@Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres.")
	@NotBlank(message = "Campo obrigatório.")
	private String name;
	
	@Size(min = 10, message = "Descrição precisa ter no minimo 10 caracteres.")
	@NotBlank(message = "Campo obrigatório.")
	private String description;
	
	@NotNull(message = "Campo obrigatório.")
	@Positive(message = "Valor não pode ser manor ou iguai a zero.")
	private Double amount;
	private String status;
	private String date;
	
	@NotNull(message = "Campo obrigatório.")
	private Long user;	
	
	@NotNull(message = "Campo obrigatório.")
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
