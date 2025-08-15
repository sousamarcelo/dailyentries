package com.practicing.dailyentries.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practicing.dailyentries.dto.DailyExpensesDTO;
import com.practicing.dailyentries.projection.DailyExpensesDetailsProjection;
import com.practicing.dailyentries.repositories.DailyExpensesRepository;

@Service
public class DailyExpensesService {
	
	@Autowired
	private DailyExpensesRepository repository;
		
	@Transactional(readOnly = true)
	public List<DailyExpensesDTO> dailyExpensesAll(){
		List<DailyExpensesDetailsProjection> list = repository.dailyExpensesAll();
		List<DailyExpensesDTO> result = list.stream().map(x -> new DailyExpensesDTO(x)).collect(Collectors.toList());
		return result;
	}
}
