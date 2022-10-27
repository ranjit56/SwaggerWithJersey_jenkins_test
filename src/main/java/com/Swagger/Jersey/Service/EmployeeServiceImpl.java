package com.Swagger.Jersey.Service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Swagger.Jersey.Entity.EmployeeEntity;
import com.Swagger.Jersey.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Transactional
	// the metadata that specifies the semantics of the transactions on a method.
	// used to combine more than one writes on a database as a single atomic
	// operation.
	public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {

		return employeeRepository.saveAndFlush(employeeEntity);
	}

	@Transactional
	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {

		return employeeRepository.saveAndFlush(employeeEntity);
	}

	@Transactional
	public EmployeeEntity fetchEmployee(Long id) {

		return employeeRepository.findById(id).orElse(null);
	}

	@Transactional
	public Boolean deleteEmployee(Long id) {
		Boolean flag = false;
		if(id == 0) {
			throw new IllegalArgumentException("Id can't be null");
		}else {
			EmployeeEntity entity = fetchEmployee(id);
			employeeRepository.deleteById(id);
			return flag;
		}
	}

	@Transactional
	public List<EmployeeEntity> fetchAllEmployees() {
		return employeeRepository.findAll();
	}

}
