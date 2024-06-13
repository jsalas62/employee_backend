package com.example.employeemanagement.services;

import com.example.employeemanagement.domains.EmployeeTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeTO> getAllEmployees();
    EmployeeTO getEmployeeById(Long id);
    EmployeeTO createEmployee(EmployeeTO employeeTO);
    EmployeeTO updateEmployee(Long id, EmployeeTO employeeTO);
    void deleteEmployee(Long id);
}
