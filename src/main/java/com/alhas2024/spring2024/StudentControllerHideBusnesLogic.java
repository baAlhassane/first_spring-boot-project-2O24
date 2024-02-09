package com.alhas2024.spring2024;

import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.util.List;
import java.util.Optional;


@RestController
public class StudentControllerHideBusnesLogic{

    private final StudentService studentService;


    public StudentControllerHideBusnesLogic(StudentService studentService) {
        this.studentService = studentService;
    }




    /*
     *  Student mapper service
     */
    @PostMapping("/student-dto-res-service")
    StudentResponseDto saveStuent(
            @RequestBody StudentDto dto){

        return this.studentService.saveStudent(dto);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent(){
        return studentService.findAllStudent();
    }


    @GetMapping("/students/{id}")
    public Student findStudentById(
           @PathVariable("sudent_id") Integer id){
        return studentService.findById(id);
    }



    @GetMapping("/students/{name}")
    public List<Student> findStudentByName(
            @PathVariable("name") String name){
        return  studentService.findStudentByName(name);
    }


    @DeleteMapping("/students/delete/{student-id}")
    public  void deleteById(
            @PathVariable("student-id") Integer id) {

        studentService.deletById(id);

    }



}
