package com.alhas2024.spring2024;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SchoolController {
  private final  SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/school")
    public School schoolPost(
            @RequestBody School school
    ){
        return  schoolRepository.save(school);
    }

    @GetMapping("/schools")
    public List<School> getAll(){

        return schoolRepository.findAll();
    }
}

