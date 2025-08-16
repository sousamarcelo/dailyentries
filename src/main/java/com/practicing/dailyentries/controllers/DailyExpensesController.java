package com.practicing.dailyentries.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicing.dailyentries.dto.DailyExpensesDTO;
import com.practicing.dailyentries.services.DailyExpensesService;

@RestController
@RequestMapping(value = "/dailyexpenses")
public class DailyExpensesController {
	
	@Autowired
	private DailyExpensesService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DailyExpensesDTO> findById(@PathVariable Long id){
		DailyExpensesDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<Page<DailyExpensesDTO>> dailyExpensesAll(Pageable pageable){
		Page<DailyExpensesDTO> dto = service.dailyExpensesAll(pageable);
		return ResponseEntity.ok(dto);
	}

}
