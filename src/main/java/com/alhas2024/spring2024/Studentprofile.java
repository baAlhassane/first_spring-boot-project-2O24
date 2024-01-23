package com.alhas2024.spring2024;

import jakarta.persistence.*;

@Entity
public class Studentprofile {
    @Id
    @GeneratedValue
    Integer id;
    String bio;
@OneToOne
@JoinColumn(
        name="student_id"
)
    private Student student;

    public Studentprofile(String bio) {
        this.bio = bio;
    }

    public Studentprofile() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
