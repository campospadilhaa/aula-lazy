package com.campospadilha.a.aula_lazy.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campospadilha.a.aula_lazy.dto.EmployeeDepartmentDTO;
import com.campospadilha.a.aula_lazy.dto.EmployeeMinDTO;
import com.campospadilha.a.aula_lazy.entities.Employee;
import com.campospadilha.a.aula_lazy.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional(readOnly = true)
	public EmployeeMinDTO findByIdMin(Long id) {

		Optional<Employee> result = employeeRepository.findById(id);

		return new EmployeeMinDTO(result.get());
	}

	@Transactional(readOnly = true)
	public EmployeeDepartmentDTO findByIdWithDepartment(Long id) {

		Optional<Employee> result = employeeRepository.findById(id);

		return new EmployeeDepartmentDTO(result.get());
	}
	
	@Transactional(readOnly = true)
	public List<EmployeeDepartmentDTO> findEmployeesWithDepartments() {

		List<Employee> result = employeeRepository.findEmployeesWithDepartments();

		return result.stream().map(x -> new EmployeeDepartmentDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<EmployeeMinDTO> findByName(String name) {

		//List<Employee> listaEmployee = employeeRepository.findByName(name);
		//List<Employee> listaEmployee = employeeRepository.findByNameIgnoreCase(name);
		List<Employee> listaEmployee = employeeRepository.findByNameContainingIgnoreCase(name);

		return listaEmployee.stream().map(employee -> new EmployeeMinDTO(employee)).toList();
	}	
}