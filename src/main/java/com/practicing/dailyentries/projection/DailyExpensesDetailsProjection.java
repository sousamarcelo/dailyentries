package com.practicing.dailyentries.projection;

import java.time.LocalDate;

public interface DailyExpensesDetailsProjection {
	
	Long getId();
	LocalDate getDate();
	String getStatus();
	String getUsername();
	String getCategoryname();
	String getName();
	Double getAmount();

}
