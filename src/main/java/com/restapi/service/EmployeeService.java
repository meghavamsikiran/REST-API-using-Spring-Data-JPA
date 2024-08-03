package com.restapi.service;

import java.util.List;
import java.util.Optional;

import com.restapi.dto.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee findEmployeeById(int empId);
    void deleteEmployeeById(int empId);
    Employee updateEmployee(Employee employee);
    List<Employee> findAllEmployees();
}
