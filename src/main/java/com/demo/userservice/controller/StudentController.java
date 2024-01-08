package com.demo.userservice.controller;

import com.demo.userservice.entity.Student;
import com.demo.userservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("age-lessthan")
   public List<Student> getStudentByAgeLessThan(@RequestParam("age") Integer age){
        return studentService.getStudentByAgeLessThan(age);
    }

    @GetMapping("searched-ages")
    public List<Student> getStudentsByAges(@RequestParam("param") List<Integer> ages){
      return studentService.getStudentsByAges(ages);
    }
    @GetMapping("dob-after")
    List<Student> getStudentsBirthDateAfter(@RequestParam("dob") String birthDate){

       return studentService.getStudentsBirthDateAfter(birthDate);
    }
}
