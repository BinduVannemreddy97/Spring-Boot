package com.demo.userservice.service;

import com.demo.userservice.entity.User;
import com.demo.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAlUsers() {
        return  userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        else {
            throw  new IllegalStateException("User does not exsts with id "+id);
        }
    }

    @Override
    public String saveUser(User user) {
        userRepository.save(user);
        return "User saved successfully";
    }

    @Override
    public String updateUserById(Long id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setGender(user.getGender());
            existingUser.setAddress(user.getAddress());
            userRepository.save(existingUser);

            return "User Updated successfully";
        }
        else {
            return "Not found userId";
        }

    }



    @Override
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "DELETED";
    }

    @Override
    public String updateUserEmailId(Long id, String emailId) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User existingIser = optionalUser.get();

            if(emailId !=null && !existingIser.getEmail().equalsIgnoreCase(emailId)){
                existingIser.setEmail(emailId);
                userRepository.save(existingIser);
                return "User emilId updated successfully";
            }
            else {
                return "User emailId empty or same";
            }
        }
        else {
            return "User Not found with id";
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUserByfirstNameStartWith(String firstName) {
        return userRepository.findByFirstNameStartingWith(firstName);
    }

    @Override
    public String updateUserLastName(Long id, String lastName) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User existingIser = optionalUser.get();

            if(lastName !=null){
                existingIser.setLastName(lastName);
                userRepository.save(existingIser);
                return "User lastName updated successfully";
            }
            else {
                return "User lastName empty or same";
            }
        }
        else {
            return "User Not found with id";
        }
    }

    @Override
    public List<User> getUserBygenderIsNot(String gender) {
        return userRepository.findByGenderIsNot(gender);
    }

    @Override
    public List<User> getUserByNameContaining(String firstName) {
        return userRepository.findByfirstNameContaining(firstName);
    }

    @Override
    public List<User> getUserByEmailLike(String pattern) {
        return userRepository.findByEmailLike(pattern);
    }
}
