package com.Swagger.Jersey.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Swagger.Jersey.Entity.EmployeeEntity;

@Service
public interface EmployeeService {
	
	EmployeeEntity createEmployee(EmployeeEntity employeeEntity);

	EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

	EmployeeEntity fetchEmployee(long id);

	Boolean deleteEmployee(long id);

}
