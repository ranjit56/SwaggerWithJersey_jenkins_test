package com.Swagger.Jersey.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.Swagger.Jersey.Entity.EmployeeEntity;

@Service
public interface EmployeeService {
	
	EmployeeEntity createEmployee(EmployeeEntity employeeEntity);

	EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

	EmployeeEntity fetchEmployee(Long id);
	
	List<EmployeeEntity> fetchAllEmployees();

	Boolean deleteEmployee(Long id);

}
