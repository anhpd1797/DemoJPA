package com.example.demo.service;

import com.example.demo.model.SubjectGroup;
import com.example.demo.repos.SubjectGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectGroupService {
    private final SubjectGroupRepository subjectGroupRepository;

    @Autowired
    public SubjectGroupService(SubjectGroupRepository subjectGroupRepository) {
        this.subjectGroupRepository = subjectGroupRepository;
    }

    public List<SubjectGroup> findAllSubjectGroup() {
        try {
            return subjectGroupRepository.findAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public SubjectGroup saveSubjectGroup(SubjectGroup subjectGroup) {
        try {
            return subjectGroupRepository.save(subjectGroup);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
