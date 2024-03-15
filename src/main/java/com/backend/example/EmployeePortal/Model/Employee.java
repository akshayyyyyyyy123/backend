package com.backend.example.EmployeePortal.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Employee {

    @Id
    private int emp_id;

    @Column
    private String emp_name;

    @Column
    private String designation;

    @Column
    private int level;

    @Column
    private String email;

    @Column
    private BigInteger cell_no;

    @ManyToOne
    @JoinColumn(name = "deptID")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "managerID")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "org_id", referencedColumnName = "org_id")
    private Organisation organisation;

    @Column
    private String password;

    @Column
    private String image_url;

    @Column
    String offer_letter_url;

    @Column
    String Slack;

    @Column
    int reporting_id;

    @Column
    String batch_image_url;
}
