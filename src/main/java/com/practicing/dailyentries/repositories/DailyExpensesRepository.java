package com.practicing.dailyentries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practicing.dailyentries.entities.DailyExpenses;
import com.practicing.dailyentries.projection.DailyExpensesDetailsProjection;

@Repository
public interface DailyExpensesRepository extends JpaRepository<DailyExpenses, Long> {
	
	
	@Query(nativeQuery = true, value = """ 
			SELECT LANCAMENTOS.ID, LANCAMENTOS.DATE, LANCAMENTOS.STATUS, TB_USER.NAME AS USERNAME, TB_CATEGORY.NAME AS CATEGORYNAME , LANCAMENTOS.NAME, LANCAMENTOS.AMOUNT
			FROM TB_EXPENSES AS LANCAMENTOS
			INNER JOIN TB_CATEGORY ON LANCAMENTOS.CATEGORY_ID = TB_CATEGORY.ID 
			INNER JOIN TB_USER ON LANCAMENTOS.USER_ID = TB_USER.ID 			
			""")
	List<DailyExpensesDetailsProjection> dailyExpensesAll();
}
