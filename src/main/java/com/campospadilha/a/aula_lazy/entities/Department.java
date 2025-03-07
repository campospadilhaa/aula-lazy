package com.campospadilha.a.aula_lazy.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_department")
public class Department {

	@Id                                                
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	// por default o relaçionamento é do tipo 'fetch = FetchType.LAZY', para que os employees sejam retornados com nova busca no banco de dados somente se acionado o método 'getEmployees'
	// @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)

	// caso seja utilizado 'fetch = FetchType.EAGER', os employees sempre serão retornados quando pesquisados os Department, e nem sempre isto será necessário
	// @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)

	@OneToMany(mappedBy = "department")
	private List<Employee> employees = new ArrayList<>();

	public Department() {

	}

	public Department(Long id, String name, List<Employee> employees) {

		this.id = id;
		this.name = name;
		this.employees = employees;
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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

		Department other = (Department) obj;

		return Objects.equals(id, other.id);
	}
}