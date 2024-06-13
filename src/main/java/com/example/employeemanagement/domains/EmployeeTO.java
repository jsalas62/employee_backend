package com.example.employeemanagement.domains;

import lombok.Data;

@Data
public class EmployeeTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
