package com.alhas2024.spring2024;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    StudentResponseDto saveStudent(StudentDto dto){
        var student =studentMapper.toStudent(dto);
        var saveStudent= studentRepository.save(student);
        return studentMapper.toStudentResponseDto(saveStudent);
    }


    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(new Student());
    }

    public List<Student> findStudentByName(String name){
        return studentRepository.findAllByFirstnameContaining(name);
    }

    public void deletById(Integer id) {
        studentRepository.deleteById(id);
    }
}
