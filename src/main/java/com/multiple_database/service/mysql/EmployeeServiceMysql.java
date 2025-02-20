package com.multiple_database.service.mysql;

import com.multiple_database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeServiceMysql extends JpaRepository<Employee, Integer> {
}
