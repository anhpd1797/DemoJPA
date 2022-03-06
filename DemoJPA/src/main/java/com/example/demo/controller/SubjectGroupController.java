package com.example.demo.controller;

import com.example.demo.model.SubjectGroup;
import com.example.demo.service.SubjectGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subject-group")
public class SubjectGroupController {
    private final SubjectGroupService subjectGroupService;

    @Autowired
    public SubjectGroupController(SubjectGroupService subjectGroupService) {
        this.subjectGroupService = subjectGroupService;
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllSubjectGroup() {
        Map<String, Object> response = new HashMap<>();
        try{
            List<SubjectGroup> subjectGroupList = subjectGroupService.findAllSubjectGroup();
            response.put("subjectGroupList", subjectGroupList);
        }catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<SubjectGroup> createSubjectGroup(@RequestBody SubjectGroup subjectGroup) {
        try {
            SubjectGroup subjectGroupReturn = subjectGroupService.saveSubjectGroup(subjectGroup);
            if (subjectGroupReturn == null) {
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
