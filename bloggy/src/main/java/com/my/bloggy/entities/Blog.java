package com.my.bloggy.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue
    private Long id;
    private String comment;
    private String description;    
    
    @ManyToOne
    private User user;
    
    @OneToMany(mappedBy = "blog")
    private List<Comments> comments;
    
}
