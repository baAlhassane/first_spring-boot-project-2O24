package com.alhas2024.spring2024;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @PostMapping("/schoolDto")
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

    private SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }


    @GetMapping("/school-dto")
    public List<SchoolDto> getAllDto(){

        return schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
    }


}

