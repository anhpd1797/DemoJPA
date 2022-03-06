package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllCourse() {
        Map<String, Object> response = new HashMap<>();
        try{
            List<Course> courseList = courseService.findAllCourse();
            response.put("courseList", courseList);
        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") String raw_id) {
        Long id = Long.parseLong(raw_id);

        Course course;
        try {
            course = courseService.findCourseById(id);
        } catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        try {
            Course courseReturn = courseService.saveCourse(course);
            if (courseReturn == null) {
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
