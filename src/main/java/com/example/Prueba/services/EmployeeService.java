package com.example.Prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Prueba.model.Employee;
import com.example.Prueba.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	List<Employee> getEmployees(){
		return repository.findAll();
	}
	
}
