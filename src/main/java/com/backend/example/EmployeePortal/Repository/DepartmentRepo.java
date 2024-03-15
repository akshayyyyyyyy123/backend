package com.backend.example.EmployeePortal.Repository;

import com.backend.example.EmployeePortal.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
