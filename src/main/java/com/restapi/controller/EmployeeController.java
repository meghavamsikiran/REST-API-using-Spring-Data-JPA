package com.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.restapi.dto.Employee;
import com.restapi.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{empId}")
    public void deleteEmployee(@PathVariable("empId") int empId) {
        employeeService.deleteEmployeeById(empId);
    }

    @GetMapping("/{empId}")
	public Employee findById(@PathVariable("empId")int empId) {
		return employeeService.findEmployeeById(empId);
	}
}
