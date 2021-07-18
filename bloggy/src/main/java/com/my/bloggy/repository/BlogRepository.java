package com.my.bloggy.repository;

import com.my.bloggy.entities.Blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long>{

}
