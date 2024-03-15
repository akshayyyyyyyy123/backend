package com.backend.example.EmployeePortal.Exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(int id) {
        super("Employee not found with ID: "+id);
    }
}
