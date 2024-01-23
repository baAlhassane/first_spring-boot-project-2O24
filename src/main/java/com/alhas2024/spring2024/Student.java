package com.alhas2024.spring2024;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;



@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
   private int age;
   @OneToOne(
           mappedBy = "student",
           cascade = CascadeType.ALL
   )
   private Studentprofile studentprofile;

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )@JsonBackReference
    private School school;

    public Student(
            String firstname,
            String lastname,
            String email,
            int age)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
@Column(unique = true)
    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int name) {
        this.age = name;
    }

    public Studentprofile getStudentprofile() {
        return studentprofile;
    }

    public void setStudentprofile(Studentprofile studentprofile) {
        this.studentprofile = studentprofile;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", name=" + age +
                '}';
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
