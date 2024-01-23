package com.alhas2024.spring2024;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByFirstnameContaining(String firstname);

    List<Student> findAllByFirstnameContains(String name);
    //List<Student> findAllByFirstnameContains(String firstname);
}
