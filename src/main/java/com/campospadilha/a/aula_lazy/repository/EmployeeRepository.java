package com.campospadilha.a.aula_lazy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campospadilha.a.aula_lazy.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT obj FROM Employee obj JOIN FETCH obj.department")
	List<Employee> findEmployeesWithDepartments();

	// Query Methods: o nome do método já define o que deverá ser realizado
	List<Employee> findByName(String name);
	List<Employee> findByNameIgnoreCase(String name);
	List<Employee> findByNameContainingIgnoreCase(String name);
}