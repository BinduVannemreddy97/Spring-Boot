package com.demo.userservice.service;

import com.demo.userservice.entity.Student;

import java.time.ZonedDateTime;
import java.util.List;

public interface StudentService {
    List<Student> getStudentByAgeLessThan(Integer age);
    List<Student> getStudentsByAges(List<Integer> ages);
    List<Student> getStudentsBirthDateAfter(String birthDate);
    List<Student> getStudentsByAgeAndActive(String age,Boolean active);
    List<Student> getStudentsByAgeOrderByFirstNameAsc(String age);
}
