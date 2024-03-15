package com.backend.example.EmployeePortal.Controller;

import com.backend.example.EmployeePortal.Exception.EmployeeNotFoundException;
import com.backend.example.EmployeePortal.Model.Department;
import com.backend.example.EmployeePortal.Model.Employee;
import com.backend.example.EmployeePortal.Model.Manager;
import com.backend.example.EmployeePortal.Repository.DepartmentRepo;
import com.backend.example.EmployeePortal.Repository.EmpRepo;

import com.backend.example.EmployeePortal.Repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:5173/")
public class ControllerClass {

    private  EmpRepo empRepo;
    private  ManagerRepo managerRepo;
    private DepartmentRepo departmentRepo;
    @Autowired
    public ControllerClass(EmpRepo empRepo, ManagerRepo managerRepo, DepartmentRepo departmentRepo) {
       this.managerRepo = managerRepo;
       this.empRepo = empRepo;
       this.departmentRepo = departmentRepo;
   }

    @PostMapping("/login")
    public ResponseEntity<Employee> login(@RequestBody Employee loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        if (empRepo.authenticate(email, password)) {
            return ResponseEntity.ok(empRepo.findByEmail(email)); // Login successful
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Login failed
        }
    }

    @GetMapping("/allEmployees/list")
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @GetMapping("/allManagers")
    public List<Manager> getAllManagers() {
        return managerRepo.findAll();
    }

    @GetMapping("/departmentNames")
    public List<Department> getallDepartment() {
        return departmentRepo.findAll();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id) {
        return Optional.ofNullable(empRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id)));
    }

    @GetMapping("/employeeNames")
    public List<Map<String, String>> getAllEmployeeNames() {
        List<Employee> employees = empRepo.findAll();
        return employees.stream().map(employee -> {
            Map<String, String> empData = new HashMap<>();
            empData.put("name", employee.getEmp_name());
            empData.put("id", String.valueOf(employee.getEmp_id()));
            empData.put("image", String.valueOf(employee.getImage_url()));
            return empData;
        }).collect(Collectors.toList());
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@RequestBody Employee updatedEmployee, @PathVariable int id) {
        System.out.println(updatedEmployee);
        return empRepo.findById(id).map(existingEmployee -> {
            existingEmployee.setCell_no(updatedEmployee.getCell_no());
            existingEmployee.setImage_url(updatedEmployee.getImage_url());
            return empRepo.save(existingEmployee);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    @GetMapping("manager/{id}")
    List<Employee> allEmployees(@PathVariable int id) {
        return empRepo.findReporties(id);
    }

    @GetMapping("/employee/children/{id}")
    List<Employee> findEmployeeChildren(@PathVariable int id) {
        return empRepo.findEmployeeChildren(id);
    }

    @GetMapping("/employee/parent/{id}")
    List<Employee> findEmployeeParent(@PathVariable int id) {
        return empRepo.findEmpParent(id);
    }
}