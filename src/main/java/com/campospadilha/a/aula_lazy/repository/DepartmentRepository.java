package com.campospadilha.a.aula_lazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campospadilha.a.aula_lazy.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}