package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectGroup extends BaseModel{
    @Column
    private String name;

    @Column
    private String description;
}
