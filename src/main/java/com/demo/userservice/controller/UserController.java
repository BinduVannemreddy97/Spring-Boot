package com.demo.userservice.controller;

import com.demo.userservice.entity.User;
import com.demo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAlUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/getByEmail")
    public User getUserByEmail(@RequestParam String email){
        return  userService.getUserByEmail(email);
    }

    @GetMapping("/findByFirstName")
    public List<User> getUserByfirstNameStartWith(@RequestParam String firstName){
        return userService.getUserByfirstNameStartWith(firstName);
    }

    @GetMapping("/gender-not")
    public List<User> getUsersBygenderIsNot(@RequestParam String gender){
        return userService.getUserBygenderIsNot(gender);
    }
    @GetMapping("firstname-contains")
    public List<User> getUsersByFirstNameContaining(@RequestParam String firstName){
        return  userService.getUserByNameContaining(firstName);
    }

    @GetMapping("email-like")
    public List<User> getUsersByEmailLike(@RequestParam String pattern){
        return  userService.getUserByEmailLike(pattern);
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @PutMapping("/{id}")
    public String updateUserById(@RequestBody User user,@PathVariable Long id){
        return userService.updateUserById(id,user);
    }
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id){
        return userService.deleteUserById(id);

    }
    @PatchMapping("/{id}")
    public String updateUserEmailId(@PathVariable Long id, @RequestParam String emailId){
        return userService.updateUserEmailId(id,emailId);
    }
    @PatchMapping("updateUserLastName/{id}")
    public String updateUserLastName(@PathVariable Long id, @RequestParam String lastName){
        return userService.updateUserLastName(id,lastName);
    }
}
