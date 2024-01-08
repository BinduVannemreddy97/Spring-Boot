package com.demo.userservice.service;

import com.demo.userservice.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

public interface UserService {
    List<User> getAlUsers();
    User getUserById(Long id);
    String saveUser(User User);
    String updateUserById(Long id, User User);
    String deleteUserById(Long id);
    String updateUserEmailId(Long id,String emailId);

    User getUserByEmail(String email);
    List<User> getUserByfirstNameStartWith(String firstName);
    String updateUserLastName(Long id, String lastName);
    List<User> getUserBygenderIsNot(String gender);
    List<User> getUserByNameContaining(String firstName);

    List<User> getUserByEmailLike(String pattern);


}
