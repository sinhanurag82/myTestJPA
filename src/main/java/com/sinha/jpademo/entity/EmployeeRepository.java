package com.sinha.jpademo.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository <Employee , String> {

    List<Employee> findById(String id);
}
