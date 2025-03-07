package com.campospadilha.a.aula_lazy.dto;

import java.io.Serializable;
import java.util.Objects;

import com.campospadilha.a.aula_lazy.entities.Department;

public class DepartmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Long id;
	public String name;
	
	public DepartmentDTO() {

	}

	public DepartmentDTO(Long id, String name) {

		this.id = id;
		this.name = name;
	}
	
	public DepartmentDTO(Department department) {

		id = department.getId();
		name = department.getName();
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

		DepartmentDTO other = (DepartmentDTO) obj;

		return Objects.equals(id, other.id);
	}
}