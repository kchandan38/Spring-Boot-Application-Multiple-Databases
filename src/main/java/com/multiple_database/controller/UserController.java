package com.multiple_database.controller;

import com.multiple_database.entity.Salary;
import com.multiple_database.entity.Employee;
import com.multiple_database.service.mysql.EmployeeServiceMysql;
import com.multiple_database.service.postgres.SalaryServicePostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apis")
public class UserController {

    @Autowired
    EmployeeServiceMysql employeeServiceMysql;
    @Autowired
    SalaryServicePostgres salaryServicePostgres;

    @PostMapping("/userymsqldata")
    public Employee employeeMysql(@RequestBody Employee user) {
        return Optional.of(employeeServiceMysql.save(user)).orElse(null);
    }
    @GetMapping("/users")
    public List<Employee> userList() {

        return Optional.of(employeeServiceMysql.findAll()).orElse(null);
    }
    @PostMapping("/salarypostgresdata")
    public Salary userPostgres(@RequestBody Salary salary) {
        return Optional.of(salaryServicePostgres.save(salary)).orElse(null);
    }
    @GetMapping("/usersalaries")
    public List<Salary> salaryList() {

        return Optional.of(salaryServicePostgres.findAll()).orElse(null);
    }

}
