package com.company.employee.model;

import javax.persistence.*;

@Entity
@Table(name="Company_Employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="employee_name")
    private  String employeeName;

    @Column(name="employee_email")
    private  String employeeEmail;

    @Column(name="employee_mobile")
    private  String employeeMobile;

    @Column(name="employee_company")
    private  String employeeCompany;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeMobile() {
        return employeeMobile;
    }

    public void setEmployeeMobile(String employeeMobile) {
        this.employeeMobile = employeeMobile;
    }

    public String getEmployeeCompany() {
        return employeeCompany;
    }

    public void setEmployeeCompany(String employeeCompany) {
        this.employeeCompany = employeeCompany;
    }

    @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + " , employeeName="+ employeeName + " , employeeEmail= "+ employeeEmail +
                " , employeeMobile=" + employeeMobile + " , employeeCompany=" + employeeCompany+ "]";

    }
}
