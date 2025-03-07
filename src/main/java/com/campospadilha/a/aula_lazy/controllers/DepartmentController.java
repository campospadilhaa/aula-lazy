package com.campospadilha.a.aula_lazy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campospadilha.a.aula_lazy.dto.DepartmentDTO;
import com.campospadilha.a.aula_lazy.dto.EmployeeMinDTO;
import com.campospadilha.a.aula_lazy.services.DepartmentService;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id) {

		DepartmentDTO obj = departmentService.findById(id);

		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/{id}/employees")
	public ResponseEntity<List<EmployeeMinDTO>> findEmployeesByDepartment(@PathVariable Long id) {

		List<EmployeeMinDTO> list = departmentService.findEmployeesByDepartment(id);

		return ResponseEntity.ok(list);
	}	
}