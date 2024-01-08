package com.demo.userservice.repo;

import com.demo.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
    public List<User> findByFirstNameStartingWith(String firstName);
    public List<User> findByGenderIsNot(String gender);
    public List<User> findByfirstNameContaining(String firstName);

    public List<User> findByEmailLike(String pattern);

}
