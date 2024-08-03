package com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.dto.Employee;
import com.restapi.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(int empId) {
		Employee temp = findAllEmployees().stream()
					.filter(e->e.getEmpId()==empId)
					.findFirst()
					.orElse(null);
		return temp;
	}

    @Override
    public void deleteEmployeeById(int empId) {
        employeeRepo.deleteById(empId);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
}
