package com.obuhovskaya.java.task.rest;

import com.obuhovskaya.java.task.dto.Employee;
import com.obuhovskaya.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public int addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping(path = "{employeeId}")
    public Employee getById(@PathVariable("employeeId") Long employeeId) {
        return employeeService.getById(employeeId).orElse(null);
    }

    @PutMapping(path = "{employeeId}")
    public void updateById(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employee) {
        employeeService.updateById(employeeId, employee);
    }

    @DeleteMapping(path = "{employeeId}")
    public void deleteById(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteById(employeeId);
    }
}


