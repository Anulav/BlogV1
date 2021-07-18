package com.my.bloggy.vo;

import com.my.bloggy.entities.Comments;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BlogVO {

    private long id;
    private String comment;
    private String description;
    private String content;    
    
    private UserVO user = new UserVO();
    
    private List<Comments> comments = new ArrayList<>();
}
