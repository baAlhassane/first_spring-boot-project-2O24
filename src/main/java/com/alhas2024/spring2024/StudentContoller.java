package com.alhas2024.spring2024;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentContoller {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentContoller(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    @PostMapping("/student")
    Student postStudent(
            @RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/student")
    List<Student> getAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/student/{student-id}")
    Student getStudentBuIdt(
            @PathVariable("student-id") int id){
        return studentRepository.findById(id).orElse(new Student());
    }
    @GetMapping("/student/search/{student-name}")
    List<Student> findStudentByname(
            @PathVariable("student-name") String name){
        return studentRepository.findAllByFirstnameContaining(name);
    }
    @GetMapping("/student/searchc/{student-name}")
    List<Student> findStudentBynameC(
            @PathVariable("student-name") String name){

        return studentRepository.findAllByFirstnameContains(name);
    }

    @DeleteMapping("student/{student-id}")
   public Student deleteById(
    @PathVariable("student-id") int id)
    {
        Student student= studentRepository.findById(id).orElse(new Student());
        studentRepository.deleteById(id);
        return student;
    }

    /** DTO  Pattren **/

    @PostMapping("/student-dto")
    Student postStudentDto(
            @RequestBody StudentDto dto){
        var student =toStudent(dto);

        return studentRepository.save(student);
    }
    @PostMapping("/student-dto-res")
    StudentResponseDto postStudentDtoResponse(
            @RequestBody StudentDto dto){
        var student =toStudent(dto);
       var saveStudent= studentRepository.save(student);
        return toStudentResponseDto(saveStudent);
    }

     private Student toStudent(StudentDto dto){
        var student =new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());


        var school=new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;

     }

     private StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail());
     }




     /*
     *  Student mapper service
     */
     @PostMapping("/student-dto-res-mapper")
     StudentResponseDto postStudentDtoResponseMapper(
             @RequestBody StudentDto dto){
         var student =studentMapper.toStudent(dto);
         var saveStudent= studentRepository.save(student);
         return studentMapper.toStudentResponseDto(saveStudent);
     }




}
