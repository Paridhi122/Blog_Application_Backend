package com.project.blog.controller;


import com.project.blog.model.Blog;
import com.project.blog.model.Users;
import com.project.blog.repository.BlogRepository;
import com.project.blog.repository.UsersRepository;
import com.project.blog.service.BlogService;
import com.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UsersRepository usersRepository;

    @PostMapping("/addBlog")
    public Blog createBlog(@Valid @RequestBody Blog blog, Principal principal) {
       return blogService.addBlog(userService.getUserrId(principal),blog);
    }

    @GetMapping("/getbyid/{blog_id}")
    @ResponseBody
    public Blog getBlog(@PathVariable Long blog_id) {
        return blogRepository.findByBlogId(blog_id);
    }

    @GetMapping("/getBlogs")
    @ResponseBody
    public List<Blog> ShowBlogs(Principal principal) {
        return blogService.showBlog(userService.getUserrId(principal),principal);
    }

    @GetMapping(value = "/deleteBlog/{blog_id}")
    @ResponseBody
    public List<Blog> deleteBlog(@PathVariable Long blog_id, Principal principal) {
        return blogService.deleteBlogs(userService.getUserrId(principal),blog_id);
    }

    @PutMapping("/updateBlog/{blog_id}")
    public Blog updateBlog(@PathVariable Long blog_id, Principal principal, @Valid @RequestBody Blog newBlog) {
        return blogService.update(userService.getUserrId(principal),principal,newBlog,blog_id);
    }

    @GetMapping("/search/{title}")
    @ResponseBody
    public List<Blog> search(@PathVariable String title){
        return blogRepository.findAllByTitleContaining(title);
    }

    @GetMapping("/getbyuser/{user_id}")
    @ResponseBody
    public List<Blog> bloglist(@PathVariable Long user_id){
        Users users = usersRepository.findByUserId(user_id);
        return blogRepository.findAllByUsersOrderByCreatedAt(users);
    }

    @GetMapping("/getall")
    @ResponseBody
    public List<Blog> bloglist(){
        return blogRepository.findAllByStatus(0);
    }

}
