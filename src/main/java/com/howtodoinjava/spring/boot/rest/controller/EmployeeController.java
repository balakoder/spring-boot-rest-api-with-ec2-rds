package com.howtodoinjava.spring.boot.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.spring.boot.rest.dto.EmployeeDTO;
import com.howtodoinjava.spring.boot.rest.dto.ResponseDTO;
import com.howtodoinjava.spring.boot.rest.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired

	private EmployeeService employeeService;

	public static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/health")
	public ResponseDTO<String> getHealth() {
		log.info(" getHealth ");
		return ResponseDTO.success("Application is Running!!!");
	}
	
	@PostMapping()
	public ResponseDTO<EmployeeDTO> createEmployee(@RequestBody @Validated EmployeeDTO EmployeeDto) {
		log.info(" EmployeeDto  id: {} ", EmployeeDto);

		return ResponseDTO.success("Employee added successfully", employeeService.addEmployee(EmployeeDto));
	}

	@PutMapping()
	public ResponseDTO<EmployeeDTO> updateEmployee(@RequestBody @Validated EmployeeDTO EmployeeDto) {
		log.info(" EmployeeDto  id: {} ", EmployeeDto);

		return ResponseDTO.success("Employee updated successfully", employeeService.updateEmployee(EmployeeDto));
	}

	@GetMapping("/uuid/{uuid}")
	public ResponseDTO<EmployeeDTO> getEmployeeByUUID(@PathVariable String uuid) {
		log.info(" getEmployeeByUUID id: {} ", uuid);
		return ResponseDTO.success(" Employee found ", employeeService.getEmployeeByUUID(uuid));
	}

	@GetMapping("/{id}")
	public ResponseDTO<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
		log.info(" getEmployeeById id: {} ", id);
		return ResponseDTO.success(" getEmployeeById ", employeeService.getEmployeeById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseDTO<EmployeeDTO> deleteEmployeeById(@PathVariable Long id) {
		log.info(" deleteEmployeeById id: {} ", id);
		employeeService.deleteEmployee(id);
		return ResponseDTO.success("Employee deleted successfully");
	}

}