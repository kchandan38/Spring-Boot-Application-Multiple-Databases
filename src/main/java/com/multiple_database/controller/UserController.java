package com.multiple_database.controller;

import com.multiple_database.entity.Salary;
import com.multiple_database.entity.User;
import com.multiple_database.service.mysql.UserServiceMysql;
import com.multiple_database.service.postgres.UserServicePostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apis")
public class UserController {

    @Autowired
    UserServiceMysql userServiceMysql;
    @Autowired
    UserServicePostgres userServicePostgres;

    @PostMapping("/userymsqldata")
    public User employeeMysql(@RequestBody User user) {
        return Optional.of(userServiceMysql.save(user)).orElse(null);
    }
    @GetMapping("/users")
    public List<User> userList() {

        return Optional.of(userServiceMysql.findAll()).orElse(null);
    }
    @PostMapping("/salarypostgresdata")
    public Salary userPostgres(@RequestBody Salary salary) {
        return Optional.of(userServicePostgres.save(salary)).orElse(null);
    }
    @GetMapping("/usersalaries")
    public List<Salary> salaryList() {

        return Optional.of(userServicePostgres.findAll()).orElse(null);
    }

}
