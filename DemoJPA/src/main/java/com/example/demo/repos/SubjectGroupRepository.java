package com.example.demo.repos;

import com.example.demo.model.SubjectGroup;

import java.util.List;
import java.util.Optional;

public interface SubjectGroupRepository extends BaseRepository<SubjectGroup>{
    @Override
    List<SubjectGroup> findAll();

    @Override
    SubjectGroup save(SubjectGroup subjectGroup);

    @Override
    Optional<SubjectGroup> findById(Long aLong);
}
