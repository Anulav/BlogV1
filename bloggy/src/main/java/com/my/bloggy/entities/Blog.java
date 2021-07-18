package com.my.bloggy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String description;
    
    @Lob
    private String content;    
    
    @ManyToOne
    @JsonIgnore
    private User user;
    
    @OneToMany(mappedBy = "blog", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Comments> comments = new HashSet<>();
    
    private void addComments(Comments comment) {
	comments.add(comment);
    }
    
}
