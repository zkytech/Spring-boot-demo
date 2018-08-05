package com.BugManageSystem.Entity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    // 注意这里一定要写User 而不是user 因为这里还是对类名进行查询而不是直接对表进行查询。
    @Query(value = "select u from User u where username=?1 and password=?2 and identity=?3")
    List<User> signinCheck(String username, String password, Integer identity);

    @Query(value="select u from User u where username=?1")
    List<User> checkUsernameUnique(String username);

    User findUserById(Integer id);
}
