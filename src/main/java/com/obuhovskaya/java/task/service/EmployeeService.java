package com.obuhovskaya.java.task.service;

import com.obuhovskaya.java.task.dao.EmployeeDao;
import com.obuhovskaya.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired()
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    public Optional<Employee> getById(Long employeeId) {
        return employeeDao.getById(employeeId);
    }

    public int updateById(Long employeeId, Employee employee) {
        return employeeDao.updateById(employeeId, employee);
    }

    public int deleteById(Long employeeId) {
        return employeeDao.deleteById(employeeId);
    }
}


