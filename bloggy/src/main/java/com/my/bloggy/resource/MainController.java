package com.my.bloggy.resource;

import com.my.bloggy.entities.Blog;
import com.my.bloggy.repository.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private BlogRepository bRepository;
    
    @GetMapping("/blogs")
    private Iterable<Blog> getAllBlogs(){
	return bRepository.findAll();
    }
}
