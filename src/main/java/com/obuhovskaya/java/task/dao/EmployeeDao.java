package com.obuhovskaya.java.task.dao;

import com.obuhovskaya.java.task.dto.Employee;
import com.obuhovskaya.java.task.dto.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired()
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addEmployee(Employee employee) {
        jdbcTemplate.update
                ("INSERT INTO employee  VALUES( ?,?,?,?,?,?,?)",
                        employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                        employee.getJobTitle(), employee.getGender().toString(), employee.getDataOfBirth());
        return 0;
    }

    public List<Employee> getAllEmployee() {
        final String sql = "SELECT * FROM Employee";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Long employee_id = resultSet.getLong("employee_id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            Integer department_id = resultSet.getInt("department_id");
            String job_title = resultSet.getString("job_title");
            Gender gender = Gender.fromString(resultSet.getString("gender"));
            Date data_of_birth = resultSet.getDate("data_of_birth");
            return new Employee(employee_id, first_name, last_name, department_id, job_title, gender, data_of_birth);
        });
    }

    public Optional<Employee> getById(Long employee_id) {
        final String sql = "SELECT * FROM Employee WHERE employee_id = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{employee_id},
                (resultSet, i) -> {
                    Long employees_id = resultSet.getLong("employee_id");
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");
                    Integer department_id = resultSet.getInt("department_id");
                    String job_title = resultSet.getString("job_title");
                    Gender gender = Gender.fromString(resultSet.getString("gender"));
                    Date data_of_birth = resultSet.getDate("data_of_birth");
                    return new Employee(employees_id, first_name, last_name, department_id, job_title, gender, data_of_birth);
                });
        return Optional.ofNullable(employee);
    }

    public int updateById(Long employeeId, Employee employee) {
        jdbcTemplate.update
                ("UPDATE employee SET first_name=?,last_name=?, department_id=?, job_title=?, gender=?, data_of_birth=? WHERE employee_id=?",
                        employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                        employee.getJobTitle(), employee.getGender().toString(), employee.getDataOfBirth(), employeeId);
        return 0;
    }

    public int deleteById(Long employeeId) {
        jdbcTemplate.update
                ("DELETE  FROM employee WHERE employee_id=?", employeeId);
        return 0;
    }
}



