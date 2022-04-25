package com.example.dockersimple.service;

import com.example.dockersimple.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudent();
    Student addStudent(Student student);
    Student editStudent(Student student);
    boolean deleteStudent(Long id);
}
