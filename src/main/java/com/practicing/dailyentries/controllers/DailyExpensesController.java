package com.practicing.dailyentries.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practicing.dailyentries.dto.DailyExpensesDTO;
import com.practicing.dailyentries.dto.DailyExpensesProjectionDTO;
import com.practicing.dailyentries.services.DailyExpensesService;

@RestController
@RequestMapping(value = "/dailyexpenses")
public class DailyExpensesController {
	
	@Autowired
	private DailyExpensesService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DailyExpensesProjectionDTO> findById(@PathVariable Long id){
		DailyExpensesProjectionDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<Page<DailyExpensesProjectionDTO>> dailyExpensesAll(Pageable pageable){
		Page<DailyExpensesProjectionDTO> dto = service.dailyExpensesAll(pageable);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<DailyExpensesDTO> insert(@RequestBody DailyExpensesDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

}
