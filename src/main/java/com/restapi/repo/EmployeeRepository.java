package com.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.dto.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
