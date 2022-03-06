package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account extends BaseModel{

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 20, nullable = false)
    private String password;

//    @OneToOne(mappedBy = "account")
//    @PrimaryKeyJoinColumn
//    private Student student;

//    @OneToOne(mappedBy = "account")
//    private Student student;
}
