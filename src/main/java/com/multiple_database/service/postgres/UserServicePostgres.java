package com.multiple_database.service.postgres;

import com.multiple_database.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServicePostgres extends JpaRepository<Salary, Integer> {
}
