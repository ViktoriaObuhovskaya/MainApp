package com.obuhovskaya.java.task.dto;

import java.util.Date;

public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private Integer departmentId;
    private String jobTitle;
    private Gender gender;
    private Date dataOfBirth;

    public Employee(Long employeeId, String firstName, String lastName, Integer departmentId, String jobTitle, Gender gender, Date dataOfBirth) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.dataOfBirth = dataOfBirth;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getDataOfBirth() {
        return dataOfBirth;
    }
}
