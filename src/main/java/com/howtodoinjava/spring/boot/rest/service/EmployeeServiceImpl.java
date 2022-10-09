package com.howtodoinjava.spring.boot.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.spring.boot.rest.adapter.EmployeeAdapter;
import com.howtodoinjava.spring.boot.rest.dto.EmployeeDTO;
import com.howtodoinjava.spring.boot.rest.entity.EmployeeEntity;
import com.howtodoinjava.spring.boot.rest.exception.NoRecordException;
import com.howtodoinjava.spring.boot.rest.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO addEmployee(EmployeeDTO EmployeeDTO) {

		EmployeeEntity employeeEntity = EmployeeEntity.builder().address(EmployeeDTO.getAddress())
				.department(EmployeeDTO.getDepartment()).email(EmployeeDTO.getEmail())
				.firstName(EmployeeDTO.getFirstName()).id(EmployeeDTO.getId()).lastName(EmployeeDTO.getLastName())
				.mobile(EmployeeDTO.getMobile()).build();

		EmployeeEntity employeeEntitySaved = employeeRepository.saveAndFlush(employeeEntity);

		log.info("employee saved in database {} ", employeeEntitySaved);

		return EmployeeAdapter.getEmployeeDTO(employeeEntitySaved);
	}

	@Override
	public EmployeeDTO getEmployeeByUUID(String uuid) {

		EmployeeEntity employeeEntity = employeeRepository.findFirstByUuid(uuid);
		log.info("Get employee by uuid from database {} ", employeeEntity);
		return EmployeeAdapter.getEmployeeDTO(employeeEntity);
	}

	@Override
	public EmployeeDTO getEmployeeById(Long id) {
		Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);

		if (employeeEntity.isPresent()) {
			return EmployeeAdapter.getEmployeeDTO(employeeEntity.get());
		} else {
			throw new NoRecordException("Employee not Found!");
		}

	}

	@Override
	public void deleteEmployee(Long id) {
		Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
		if (employeeEntity.isPresent()) {
			employeeRepository.delete(employeeEntity.get());
		} else {
			throw new NoRecordException("Employee not Found!");
		}

	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDto) {

		Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeDto.getId());
		if(employeeEntity.isPresent()) {
		EmployeeEntity employeeEntityUpdate = employeeEntity.get();
		if (employeeDto.getDepartment() != null) {
			employeeEntityUpdate.setDepartment(employeeDto.getDepartment());
		}
		if (employeeDto.getFirstName() != null) {
			employeeEntityUpdate.setFirstName(employeeDto.getFirstName());

		}

		if (employeeDto.getLastName() != null) {
			employeeEntityUpdate.setLastName(employeeDto.getLastName());
		}

		if (employeeDto.getMobile() != null) {
			employeeEntityUpdate.setMobile(employeeDto.getMobile());
		}
		return EmployeeAdapter.getEmployeeDTO(employeeRepository.saveAndFlush(employeeEntityUpdate));
	}
		else {
			throw new NoRecordException("Employee not Found!");
		}
		
	}

}
