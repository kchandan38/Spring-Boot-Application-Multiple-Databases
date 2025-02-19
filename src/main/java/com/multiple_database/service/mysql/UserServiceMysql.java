package com.multiple_database.service.mysql;

import com.multiple_database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceMysql extends JpaRepository<User, Integer> {
}
