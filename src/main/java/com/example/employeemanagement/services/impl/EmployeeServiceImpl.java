package com.example.employeemanagement.services.impl;

import com.example.employeemanagement.domains.EmployeeTO;
import com.example.employeemanagement.entities.Employee;
import com.example.employeemanagement.exceptions.ResourceNotFoundException;
import com.example.employeemanagement.mappers.EmployeeMapper;
import com.example.employeemanagement.repositories.EmployeeRepository;
import com.example.employeemanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toTO) // Cambio aquí: de toDomain a toTO
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return employeeMapper.toTO(employee); // Cambio aquí: de toDomain a toTO
    }

    @Override
    public EmployeeTO createEmployee(EmployeeTO employeeTO) {
        Employee employee = employeeMapper.toEntity(employeeTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toTO(savedEmployee); // Cambio aquí: de toDomain a toTO
    }

    @Override
    public EmployeeTO updateEmployee(Long id, EmployeeTO employeeTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        existingEmployee.setFirstName(employeeTO.getFirstName());
        existingEmployee.setLastName(employeeTO.getLastName());
        existingEmployee.setEmail(employeeTO.getEmail());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return employeeMapper.toTO(updatedEmployee); // Cambio aquí: de toDomain a toTO
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(existingEmployee);
    }
}
