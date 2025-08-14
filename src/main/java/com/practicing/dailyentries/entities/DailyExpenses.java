package com.practicing.dailyentries.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_expenses")
public class DailyExpenses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String description;
	private Double amount;
	private ExpenseStatus status;
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;	
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;	
	
	public DailyExpenses() {
	}

	public DailyExpenses(Long id, String name, String description, Double amount, ExpenseStatus status, LocalDate date,
			User user, Category category) {		
		this.id = id;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.date = date;
		this.user = user;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return amount;
	}

	public void setValue(Double value) {
		this.amount = value;
	}

	public ExpenseStatus getStatus() {
		return status;
	}

	public void setStatus(ExpenseStatus status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DailyExpenses other = (DailyExpenses) obj;
		return Objects.equals(id, other.id);
	}
}
