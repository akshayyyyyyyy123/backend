package com.backend.example.EmployeePortal.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Manager {
    @Id
    private int m_id;

    @Column
    private String m_name;

    @ManyToOne
    @JoinColumn(name = "dept_id", referencedColumnName = "d_id")
    private Department department;

    public Manager() {

    }

    public Manager(int m_id, String m_name, Department department) {
        this.m_id = m_id;
        this.m_name = m_name;
        this.department = department;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
