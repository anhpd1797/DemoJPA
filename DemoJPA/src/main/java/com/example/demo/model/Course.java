package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course extends BaseModel{
    @Column
    private String name;

    @Column
    private String description;

//    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
//    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "subject_group_id")
    private SubjectGroup subjectGroup;
}
