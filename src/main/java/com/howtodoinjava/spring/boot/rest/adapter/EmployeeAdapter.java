package com.howtodoinjava.spring.boot.rest.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.spring.boot.rest.controller.EmployeeController;
import com.howtodoinjava.spring.boot.rest.dto.EmployeeDTO;
import com.howtodoinjava.spring.boot.rest.entity.EmployeeEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EmployeeAdapter {
	ObjectMapper mapper = new ObjectMapper();

	public static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	public static EmployeeDTO getEmployeeDTO(EmployeeEntity employeeEntity) {

		log.info("EmployeeEntity Email {}", employeeEntity.getEmail());

		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setAddress(employeeEntity.getAddress());

		employeeDTO.setEmail(employeeEntity.getEmail());

		employeeDTO.setId(employeeEntity.getId());

		employeeDTO.setDepartment(employeeEntity.getDepartment());

		employeeDTO.setEmployeeUuid(employeeEntity.getUuid());

		employeeDTO.setFirstName(employeeEntity.getFirstName());

		employeeDTO.setLastName(employeeEntity.getLastName());

		employeeDTO.setMobile(employeeEntity.getMobile());

		employeeDTO.setStatus(employeeEntity.isStatus());

		employeeDTO.setCreatedAt(employeeEntity.getCreatedAt());

		employeeDTO.setUpdatedAt(employeeEntity.getUpdatedAt());

		return employeeDTO;

	}

	public static List<EmployeeDTO> getListingEmployeeDTOs(List<EmployeeEntity> employeeEntity) {

		if (CollectionUtils.isEmpty(employeeEntity)) {
			return new ArrayList<>();
		}
		return employeeEntity.stream().map(EmployeeAdapter::getEmployeeDTO).collect(Collectors.toList());

	}

}