package com.my.bloggy.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String aboutMe;
    
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs;

    @OneToMany(mappedBy = "user")
    private List<Comments> comment;
}
