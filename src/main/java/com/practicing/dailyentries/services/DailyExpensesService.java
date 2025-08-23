package com.practicing.dailyentries.services;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.practicing.dailyentries.dto.DailyExpensesDTO;
import com.practicing.dailyentries.dto.DailyExpensesProjectionDTO;
import com.practicing.dailyentries.entities.Category;
import com.practicing.dailyentries.entities.DailyExpenses;
import com.practicing.dailyentries.entities.ExpenseStatus;
import com.practicing.dailyentries.entities.User;
import com.practicing.dailyentries.projection.DailyExpensesDetailsProjection;
import com.practicing.dailyentries.repositories.CategoryRepository;
import com.practicing.dailyentries.repositories.DailyExpensesRepository;
import com.practicing.dailyentries.repositories.UserRepository;
import com.practicing.dailyentries.services.exceptions.DataBaseException;
import com.practicing.dailyentries.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DailyExpensesService {
	
	@Autowired
	private DailyExpensesRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Transactional(readOnly = true)
	public DailyExpensesProjectionDTO findById(Long id) {
		try {
			Optional<DailyExpenses> result = repository.findById(id);
			DailyExpenses dailyExpenses = result.get();
			return new DailyExpensesProjectionDTO(dailyExpenses);
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("Recurso não encontrado.");
		}
	}
		
	@Transactional(readOnly = true)
	public Page<DailyExpensesProjectionDTO> dailyExpensesAll(Pageable pageable){
		Page<DailyExpensesDetailsProjection> list = repository.dailyExpensesAll(pageable);
		Page<DailyExpensesProjectionDTO> result = list.map(x -> new DailyExpensesProjectionDTO(x));
		return result;
	}
	
	@Transactional
	public DailyExpensesDTO insert(DailyExpensesDTO dto) {
		DailyExpenses entity = new DailyExpenses();
		copyDtoToEntity(dto, entity);		
		entity = repository.save(entity);
		return new DailyExpensesDTO(entity);
	}
	
	@Transactional
	public DailyExpensesDTO update(Long id, DailyExpensesDTO dto) {
		try {
			DailyExpenses entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);		
			entity = repository.save(entity);
			return new DailyExpensesDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrado.");
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recusro não encontrato.");
		}
		
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Falha de integridade referencial.");
		}		
	}

	private void copyDtoToEntity(DailyExpensesDTO dto, DailyExpenses entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setAmount(dto.getAmount());
		entity.setStatus(ExpenseStatus.valueOf(dto.getStatus()));
		entity.setDate(LocalDate.parse(dto.getDate()));
		User user = userRepository.getReferenceById(dto.getUser());
		entity.setUser(user);
		Category category = categoryRepository.getReferenceById(dto.getCategory());
		entity.setCategory(category);
		
	}
}
