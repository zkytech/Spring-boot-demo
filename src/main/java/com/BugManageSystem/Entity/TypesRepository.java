package com.BugManageSystem.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypesRepository extends JpaRepository<Types, Integer> {

    Types findTypesById(Integer id);
}
