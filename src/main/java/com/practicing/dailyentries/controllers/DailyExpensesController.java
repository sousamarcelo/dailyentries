package com.practicing.dailyentries.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicing.dailyentries.dto.DailyExpensesDTO;
import com.practicing.dailyentries.services.DailyExpensesService;

@RestController
@RequestMapping(value = "/dailyexpenses")
public class DailyExpensesController {
	
	@Autowired
	private DailyExpensesService service;
	
	@GetMapping
	public ResponseEntity<Page<DailyExpensesDTO>> dailyExpensesAll(Pageable pageable){
		Page<DailyExpensesDTO> dto = service.dailyExpensesAll(pageable);
		return ResponseEntity.ok(dto);
	}

}
