package com.campospadilha.a.aula_lazy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campospadilha.a.aula_lazy.dto.DepartmentDTO;
import com.campospadilha.a.aula_lazy.dto.EmployeeMinDTO;
import com.campospadilha.a.aula_lazy.entities.Department;
import com.campospadilha.a.aula_lazy.entities.Employee;
import com.campospadilha.a.aula_lazy.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Transactional(readOnly = true)
	public DepartmentDTO findById(Long id) {

		Optional<Department> result = departmentRepository.findById(id);

		return new DepartmentDTO(result.get());
	}

	@Transactional(readOnly = true)
	public List<EmployeeMinDTO> findEmployeesByDepartment(Long id) {

		Optional<Department> result = departmentRepository.findById(id);

		List<Employee> listEmployee = result.get().getEmployees();

		return listEmployee.stream().map(employee -> new EmployeeMinDTO(employee)).toList();
	}
}