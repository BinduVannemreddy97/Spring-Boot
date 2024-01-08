package com.demo.userservice.service;

import com.demo.userservice.entity.Student;
import com.demo.userservice.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getStudentByAgeLessThan(Integer age) {
        return studentRepository.findByAgeLessThan(age);
    }

    @Override
    public List<Student> getStudentsByAges(List<Integer> ages) {
        return studentRepository.findByAgeIn(ages);
    }

    @Override
    public List<Student> getStudentsBirthDateAfter(String birthDate) {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(birthDate);
        return studentRepository.findByBirthDateAfter(zonedDateTime);
    }

    @Override
    public List<Student> getStudentsByAgeAndActive(String age, Boolean active) {
        return studentRepository.findByAgeAndActive(age,active);
    }

    @Override
    public List<Student> getStudentsByAgeOrderByFirstNameAsc(String age) {
        return studentRepository.findByAgeOrderByFirstNameAsc(age);
    }
}
