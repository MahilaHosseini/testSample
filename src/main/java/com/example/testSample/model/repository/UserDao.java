package com.example.testSample.model.repository;

import com.example.testSample.model.entity.User;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long>  {
    User findByUserName( String username);
}
