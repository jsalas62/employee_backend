package com.example.employeemanagement.domains;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Details about the employee")
public class EmployeeTO {

    @Schema(description = "The unique ID of the employee")
    private Long id;

    @Schema(description = "The first name of the employee")
    private String firstName;

    @Schema(description = "The last name of the employee")
    private String lastName;

    @Schema(description = "The email of the employee")
    private String email;
}
