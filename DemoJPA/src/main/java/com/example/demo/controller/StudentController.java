package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllStudent() {
        Map<String, Object> response = new HashMap<>();
        try{
            List<Student> studentList = studentService.getAllStudent();
            response.put("studentList", studentList);
        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") String raw_id) {
        Long id = Long.parseLong(raw_id);

        Student student;
        try{
            student = studentService.findStudentById(id);
        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable("id") String raw_id) {
        Long id = Long.parseLong(raw_id);

        try{
            studentService.deleteStudentById(id);
        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            Student studentReturn = studentService.saveStudent(student);
            if (studentReturn == null) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
        } catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        try {
            Student studentReturn = studentService.saveStudent(student);
            if (studentReturn == null) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
        } catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
