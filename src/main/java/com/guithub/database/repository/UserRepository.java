package com.guithub.database.repository;

import com.guithub.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User saveAndFlush(User user);

    User findByUsername(String userName);
    User findByEmail(String userName);

    User findByUsernameAndActive(String username,boolean active);

    User findByEmailAndActive(String email,boolean active);

}
