package com.demo.userservice.repo;

import com.demo.userservice.entity.Student;
import com.demo.userservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    List<Student> findByAgeLessThan(Integer age);
    List<Student> findByAgeIn(List<Integer> ages);
    List<Student> findByBirthDateAfter(ZonedDateTime     birthDate);
    List<Student> findByAgeAndActive(String age,Boolean active);

    List<Student> findByAgeOrderByFirstNameAsc(String Age);

}
