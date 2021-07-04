package com.my.bloggy.repository;

import com.my.bloggy.entities.Blog;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long>{

    Iterable<Blog> findAll();
}
