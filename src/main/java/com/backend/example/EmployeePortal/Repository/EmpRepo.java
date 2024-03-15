package com.backend.example.EmployeePortal.Repository;

import com.backend.example.EmployeePortal.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

    @Query("SELECT e.emp_name FROM Employee e WHERE e.manager.id = :id")
    List<String> findEmployeeNamesByManagerId(int id);

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Employee e WHERE e.email = :email AND e.password = :password")
    boolean authenticate(@Param("email") String email, @Param("password") String password);

    @Query("SELECT e FROM Employee e WHERE e.emp_name = :name")
    List<Employee> findByName(@Param("name") String name);

    public Employee findByEmail(String email);

    @Query("Select e from Employee e where e.manager.id= :id")
    List<Employee> findReporties(@Param("id") int id);

    @Query("Select e from Employee e where e.reporting_id = :id")
    List<Employee> findEmployeeChildren(@Param("id") int id);

    @Query("SELECT e FROM Employee e WHERE e.emp_id IN (SELECT e2.reporting_id FROM Employee e2 WHERE e2.emp_id = :id)")
    List<Employee> findEmpParent(@Param("id") int id);
}
