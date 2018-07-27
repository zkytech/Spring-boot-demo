package com.BugManageSystem.Entity;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Long> {

    Bug findBugByid(Long id);

    List<Bug> findAllByBugnameLike(String keyword);

    List<Bug> findAllByBugnameContains(String keyword);
    List<Bug> findAllByBugnameContains(String keyword, Pageable pageable);


}
