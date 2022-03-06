package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        try {
            return studentRepository.findAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Data with this id: " + id + " is not found"));
    }

    public void deleteStudentById(Long id) {
        try {
            studentRepository.deleteById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public Student saveStudent(Student student) {
        try {
            return studentRepository.save(student);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
