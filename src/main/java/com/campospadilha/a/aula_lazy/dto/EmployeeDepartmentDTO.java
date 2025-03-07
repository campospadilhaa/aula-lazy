package com.campospadilha.a.aula_lazy.dto;

import java.io.Serializable;
import java.util.Objects;

import com.campospadilha.a.aula_lazy.entities.Employee;

public class EmployeeDepartmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private DepartmentDTO department;
	
	public EmployeeDepartmentDTO() {

	}

	public EmployeeDepartmentDTO(Long id, String name, String email, DepartmentDTO department) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
	}

	public EmployeeDepartmentDTO(Employee employee) {

		id = employee.getId();
		name = employee.getName();
		email = employee.getEmail();
		department = new DepartmentDTO(employee.getDepartment());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		EmployeeDepartmentDTO other = (EmployeeDepartmentDTO) obj;

		return Objects.equals(id, other.id);
	}
}