package com.example.dockersimple.service;

import com.example.dockersimple.entity.Student;
import com.example.dockersimple.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements IStudentService {
    @Autowired
    StudentRepository repository;

    @Override
    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student editStudent(Student student) {
        if (checkId(student.getId())) {
            Student studentDb = repository.findStudentById(student.getId());

            studentDb.setAddress(student.getAddress());
            studentDb.setBirthday(student.getBirthday());
            studentDb.setName(student.getName());

            return repository.save(studentDb);
        }
        return null;
    }

    @Override
    public boolean deleteStudent(Long id) {
        if (checkId(id)) {
            repository.deleteStudentById(id);
            return true;
        } else {
            return false;
        }
    }

    private boolean checkId(Long id) {
        if (id != null)
            return repository.existsById(id);
        else
            return false;
    }
}
