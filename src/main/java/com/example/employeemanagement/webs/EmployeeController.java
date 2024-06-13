package com.example.employeemanagement.webs;

import com.example.employeemanagement.domains.EmployeeTO;
import com.example.employeemanagement.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee API", description = "API for managing employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees")
    @GetMapping
    public List<EmployeeTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Operation(summary = "Get employee by ID", description = "Retrieve an employee by their ID")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeTO> getEmployeeById(@PathVariable Long id) {
        EmployeeTO employeeTO = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeTO);
    }

    @Operation(summary = "Create a new employee", description = "Add a new employee to the database")
    @PostMapping
    public ResponseEntity<EmployeeTO> createEmployee(@RequestBody EmployeeTO employeeTO) {
        EmployeeTO createdEmployee = employeeService.createEmployee(employeeTO);
        return ResponseEntity.status(201).body(createdEmployee);
    }

    @Operation(summary = "Update an employee", description = "Update an existing employee's details")
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeTO employeeTO) {
        EmployeeTO updatedEmployee = employeeService.updateEmployee(id, employeeTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @Operation(summary = "Delete an employee", description = "Delete an employee from the database")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
