package com.BugManageSystem.Entity;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Long> {

    Bug findBugByid(Long id);
    List<Bug> findAllByBugnameContains(String keyword);
    List<Bug> findAllByBugnameContains(String keyword, Pageable pageable);
    List<Bug> findAllByBugnameIgnoreCaseContains(String keyword);
    List<Bug> findAllByBugnameIgnoreCaseContains(String keyword, Pageable pageable);

    List<Bug> findAllByBugnameIgnoreCaseContainsAndSubmituser(String keyword, Integer submituser, Pageable pageable);
    List<Bug> findAllByBugnameIgnoreCaseContainsAndSubmituser(String keyword, Integer submituser);
    List<Bug> findAllByBugnameContainsAndSubmituser(String keyword, Integer submituser, Pageable pageable);
    List<Bug> findAllByBugnameContainsAndSubmituser(String keyword, Integer submituser);
    List<Bug> findAllBySubmituser(Integer submituser);
    List<Bug> findAllBySubmituser(Integer submituser,Pageable pageable);
    List<Bug> findAllByBugnameIgnoreCaseContainsAndCheckstatusIn(String keyword,List<Integer> checkstatuses,Pageable pageable);
    List<Bug> findAllByBugnameIgnoreCaseContainsAndCheckstatusIn(String keyword,List<Integer> checkstatuses);
    List<Bug> findAllByBugnameIgnoreCaseContainsAndSubmituserAndCheckstatusIn(String keyword, Integer submituser, List<Integer> checkstatuses,Pageable pageable);
    List<Bug> findAllByBugnameIgnoreCaseContainsAndSubmituserAndCheckstatusIn(String keyword, Integer submituser, List<Integer> checkstatuses);
    Bug findBugByIdAndSubmituser(Long id, Integer submituser);

}
