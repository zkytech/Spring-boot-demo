package com.zkytech.DataBaseIO_Example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long > {
//    List<User> findByName(String name);
    User findUserById(Long id);



}
