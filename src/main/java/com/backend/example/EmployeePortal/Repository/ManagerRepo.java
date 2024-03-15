package com.backend.example.EmployeePortal.Repository;

import com.backend.example.EmployeePortal.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepo extends JpaRepository<Manager, Integer> {

}
