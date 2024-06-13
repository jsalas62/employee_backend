package com.example.employeemanagement.webs;

import com.example.employeemanagement.domains.EmployeeTO;
import com.example.employeemanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeTO> getEmployeeById(@PathVariable Long id) {
        EmployeeTO employeeTO = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeTO);
    }

    @PostMapping
    public ResponseEntity<EmployeeTO> createEmployee(@RequestBody EmployeeTO employeeTO) {
        EmployeeTO createdEmployee = employeeService.createEmployee(employeeTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeTO employeeTO) {
        EmployeeTO updatedEmployee = employeeService.updateEmployee(id, employeeTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
