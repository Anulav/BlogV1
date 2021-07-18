package com.my.bloggy.resource;

import com.my.bloggy.entities.Blog;
import com.my.bloggy.entities.User;
import com.my.bloggy.repository.BlogRepository;
import com.my.bloggy.repository.UserRepository;
import com.my.bloggy.vo.BlogVO;
import com.my.bloggy.vo.UserLoginVO;
import com.my.bloggy.vo.UserVO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private BlogRepository bRepository;
    
    @Autowired
    private UserRepository uRepository;
    
    @GetMapping("/blogs")
    private ResponseEntity<List<BlogVO>> getAllBlogs(){
	
	List<BlogVO> blogVOs = bRepository.findAll().stream().map(i -> { BlogVO blogVO = new BlogVO();
	BeanUtils.copyProperties(i,blogVO);
	BeanUtils.copyProperties(i.getComments(),blogVO.getComments());
	BeanUtils.copyProperties(i.getUser(),blogVO.getUser());
	return blogVO;
	}).collect(Collectors.toList());
	return new ResponseEntity<List<BlogVO>>(blogVOs, HttpStatus.OK);
    }
    
    @PostMapping("/{userId}/write")
    @ResponseStatus(code = HttpStatus.CREATED)
    private void saveAndRedirect(@RequestBody BlogVO blogVO, @PathVariable long userId){
	Optional<User> user = uRepository.findById(userId);
	Blog blog = new Blog();
	BeanUtils.copyProperties(blogVO, blog);
	blog.setUser(user.get());
	bRepository.save(blog);
    }
    
    @PostMapping("/signin")
    private ResponseEntity<UserVO> createAUserAndReturn(@RequestBody UserLoginVO userLoginVO){
	User user = new User();
	BeanUtils.copyProperties(userLoginVO, user);
	user = uRepository.save(user);
	UserVO userVO = new UserVO();
	BeanUtils.copyProperties(user, userVO);
	return new ResponseEntity<UserVO>(userVO,HttpStatus.CREATED);
    }
}
