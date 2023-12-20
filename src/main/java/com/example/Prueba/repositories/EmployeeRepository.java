package com.example.Prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Prueba.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
