package com.practicing.dailyentries.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practicing.dailyentries.dto.DailyExpensesDTO;
import com.practicing.dailyentries.entities.DailyExpenses;
import com.practicing.dailyentries.projection.DailyExpensesDetailsProjection;
import com.practicing.dailyentries.repositories.DailyExpensesRepository;

@Service
public class DailyExpensesService {
	
	@Autowired
	private DailyExpensesRepository repository;
	
	@Transactional(readOnly = true)
	public DailyExpensesDTO findById(Long id) {
		Optional<DailyExpenses> result = repository.findById(id);
		DailyExpenses dailyExpenses = result.get();
		return new DailyExpensesDTO(dailyExpenses);
	}
		
	@Transactional(readOnly = true)
	public Page<DailyExpensesDTO> dailyExpensesAll(Pageable pageable){
		Page<DailyExpensesDetailsProjection> list = repository.dailyExpensesAll(pageable);
		Page<DailyExpensesDTO> result = list.map(x -> new DailyExpensesDTO(x));
		return result;
	}
}
