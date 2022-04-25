package com.example.dockersimple.controller;

import com.example.dockersimple.entity.Student;
import com.example.dockersimple.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    IStudentService studentService;

    @GetMapping("/")
    public ResponseEntity getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @PostMapping("/")
    public ResponseEntity addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @PutMapping("/")
    public ResponseEntity editStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.editStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
