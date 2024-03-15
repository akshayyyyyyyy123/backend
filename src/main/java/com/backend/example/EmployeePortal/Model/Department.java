package com.backend.example.EmployeePortal.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Department {
    @Id
    private int d_id;

    @Column
    private String d_name;

    @ManyToOne
    @JoinColumn(name = "org_id", referencedColumnName = "org_id")
    private Organisation organisation;

    @Column
    private String hod;

    public Department() {

    }

    public Department(int d_id, String d_name, Organisation organisation, String hod) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.organisation = organisation;
        this.hod = hod;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public String getHod() {
        return hod;
    }

    public void setHod(String hod) {
        this.hod = hod;
    }
}
