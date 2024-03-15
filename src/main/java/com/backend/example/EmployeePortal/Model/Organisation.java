package com.backend.example.EmployeePortal.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table
public class Organisation {
    @Id
    private Integer org_id;
    @Column
    private String org_name;

    public Organisation() {

    }

    public Organisation(int org_id, String org_name) {
        this.org_id = org_id;
        this.org_name = org_name;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }
}
