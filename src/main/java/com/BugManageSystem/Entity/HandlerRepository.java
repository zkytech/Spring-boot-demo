package com.BugManageSystem.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HandlerRepository extends JpaRepository<Handler, Integer> {
        List<Handler> findAllByDepartment(Integer departmentId);
}
