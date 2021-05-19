package com.example.heroku;


import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private int eid;
    private String ename;
    private long esalary;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public long getEsalary() {
        return esalary;
    }

    public void setEsalary(long esalary) {
        this.esalary = esalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esalary=" + esalary +
                '}';
    }
}
