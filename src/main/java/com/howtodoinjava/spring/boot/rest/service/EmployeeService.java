package com.howtodoinjava.spring.boot.rest.service;

import com.howtodoinjava.spring.boot.rest.dto.EmployeeDTO;

public interface EmployeeService {

	public EmployeeDTO addEmployee(EmployeeDTO employeeDto);

	public EmployeeDTO getEmployeeByUUID(String uuid);

	public EmployeeDTO getEmployeeById(Long id);

	public void deleteEmployee(Long id);

	public EmployeeDTO updateEmployee(EmployeeDTO employeeDto);

}
