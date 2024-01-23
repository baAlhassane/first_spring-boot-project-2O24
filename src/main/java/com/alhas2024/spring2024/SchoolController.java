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

    /** School DTO**/
    @PostMapping("/school")
    public SchoolDto schoolPostDto(
            @RequestBody SchoolDto dto
    ){
       var school=toSchool(dto);
       schoolRepository.save(school);

        return  dto;
    }

    private School toSchool(SchoolDto dto) {
        return new School(
                dto.name() );
    }
}

