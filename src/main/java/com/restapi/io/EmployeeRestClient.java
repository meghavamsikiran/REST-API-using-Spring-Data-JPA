package com.restapi.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.restapi.dto.Employee;
import com.restapi.util.DateConverter;

public class EmployeeRestClient {
    static RestTemplate template = new RestTemplate();
    static String url = "http://localhost:8000/spring-datajpa-restapi-employee/api/employees";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add Employee");
            System.out.println("2. Find All Employees");
            System.out.println("3. Find Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee by ID");
            System.out.println("6. Exit");

            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    findAll();
                    break;
                case 3:
                    findById();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    deleteById();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void findAll() {
        try {
            Employee[] e = template.getForObject(url, Employee[].class);
            if (e != null) {
                for (Employee temp : e) {
                    System.out.println(temp);
                }
            } else {
                System.out.println("No employees found.");
            }
        } catch (Exception e) {
            System.err.println("Error fetching employees: " + e.getMessage());
        }
    }

    public static void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter Employee Name: ");
            String empName = sc.nextLine();
            System.out.println("Enter empAge: ");
            int empAge = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Date of Join(yyyy-MM-dd): ");
            String dateOfJoin = sc.nextLine();
            
            Employee employee = new Employee(empId, empName, empAge, DateConverter.convertStringToSQLDate(dateOfJoin));
            Employee added = template.postForObject(url, employee, Employee.class);
            if (added != null) {
                System.out.println("===> Record Added Successfully!");
                System.out.println(added.getEmpId() + " : " + added.getEmpName());
            } else {
                System.out.println("Failed to add record.");
            }
        } catch (Exception e) {
            System.err.println("Error adding employee: " + e.getMessage());
        }
    }

    public static void findById() {
        try {
            System.out.print("Enter Employee ID to find: ");
            int empId = sc.nextInt();

            String tempUrl = url + "/{empId}";
            Map<String, Integer> paramMap = new HashMap<>();
            paramMap.put("empId", empId);

            Employee search = template.getForObject(tempUrl, Employee.class, paramMap);
            if (search != null) {
                System.out.println(search.getEmpId() + " : " + search.getEmpName()+" : "+search.getEmpAge()+" : "+search.getDateOfJoin());
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception e) {
            System.err.println("Error finding employee: " + e.getMessage());
        }
    }

    public static void deleteById() {
        try {
            System.out.print("Enter Employee ID to delete: ");
            int empId = sc.nextInt();
            sc.nextLine(); // consume newline

            String tempUrl = url + "/{empId}";
            Map<String, Integer> paramMap = new HashMap<>();
            paramMap.put("empId", empId);

            template.delete(tempUrl, paramMap);
            System.out.println("===> Employee deleted successfully!");
        } catch (Exception e) {
            System.err.println("Error deleting employee: " + e.getMessage());
        }
    }

    public static void updateEmployee() {
        try {
            System.out.print("Enter Employee ID to update: ");
            int empId = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter New Employee Name: ");
            String empName = sc.nextLine();
            System.out.println("Enter new empAge: ");
            int empAge = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter new Date of Join(yyyy-MM-dd): ");
            String dateOfJoin = sc.nextLine();
            
            Employee employee = new Employee(empId, empName, empAge, DateConverter.convertStringToSQLDate(dateOfJoin));
            template.put(url, employee);
            System.out.println("===> Record Updated... printing all records after update");
            findAll();
        } catch (Exception e) {
            System.err.println("Error updating employee: " + e.getMessage());
        }
    }

}
