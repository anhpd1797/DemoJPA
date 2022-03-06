package com.example.demo.repos;

import com.example.demo.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends BaseRepository<Course>{
    @Override
    List<Course> findAll();

    @Override
    Course save(Course course);

    @Override
    Optional<Course> findById(Long aLong);
}
