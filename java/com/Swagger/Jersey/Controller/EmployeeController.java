package com.Swagger.Jersey.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Swagger.Jersey.Entity.EmployeeEntity;
import com.Swagger.Jersey.Service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// Save the resource
    
	@PostMapping("/Save")
	public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
		return employeeService.createEmployee(employeeEntity);
	}

	// Updates the resource
    @PutMapping("/update")
	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		return employeeService.updateEmployee(employeeEntity);
	}

	// Retrive the resource
	@GetMapping("/get")
	public EmployeeEntity fetchEmployee(long id) {
		return employeeService.fetchEmployee(id);

	}

	// Delete the resource
	@DeleteMapping("/delete")
	public Boolean deleteById(long id) {
		return employeeService.deleteEmployee(id);
	}
	
}