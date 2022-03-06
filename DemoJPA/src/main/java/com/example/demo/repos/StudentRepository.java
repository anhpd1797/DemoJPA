package com.example.demo.repos;

import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends BaseRepository<Student>{
    @Override
    List<Student> findAll();

    @Override
    Optional<Student> findById(Long id);

    @Override
    void deleteById(Long aLong);

    @Override
    Student save(Student student);
}
