package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repos.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course saveCourse(Course course) {
        try {
            return courseRepository.save(course);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Course findCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Data with this id: " + id + " is not found"));
    }

    public List<Course> findAllCourse() {
        try {
            return courseRepository.findAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}
