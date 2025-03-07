package com.campospadilha.a.aula_lazy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campospadilha.a.aula_lazy.dto.EmployeeDepartmentDTO;
import com.campospadilha.a.aula_lazy.dto.EmployeeMinDTO;
import com.campospadilha.a.aula_lazy.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/{id}/min")
	public ResponseEntity<EmployeeMinDTO> findByIdMin(@PathVariable Long id) {

		EmployeeMinDTO obj = employeeService.findByIdMin(id);

		return ResponseEntity.ok(obj);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDepartmentDTO> findByIdWithDepartment(@PathVariable Long id) {

		EmployeeDepartmentDTO obj = employeeService.findByIdWithDepartment(id);

		return ResponseEntity.ok(obj);
	}

	/* comentado para utilizar o método findByName(String)
	@GetMapping*/
	public ResponseEntity<List<EmployeeDepartmentDTO>> findEmployeesWithDepartments() {

		List<EmployeeDepartmentDTO> list = employeeService.findEmployeesWithDepartments();

		return ResponseEntity.ok(list);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeMinDTO>> findByName(@RequestParam(name = "name", defaultValue = "") String name) {

		//List<EmployeeMinDTO> listaEmployeeMinDTO = employeeService.findByName(name);
		List<EmployeeMinDTO> listaEmployeeMinDTO = employeeService.findByName(name);

		return ResponseEntity.ok(listaEmployeeMinDTO);
	}}