package com.my.bloggy.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Comments {

    @Id
    @GeneratedValue
    private Long id;
    private String comments;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Blog blog;
    
}
