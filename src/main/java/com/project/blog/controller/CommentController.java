//package com.project.blog.controller;
//
//import com.project.blog.model.Blog;
//import com.project.blog.model.Comments;
//import com.project.blog.repository.BlogRepository;
//import com.project.blog.repository.CommentRepository;
//import com.project.blog.repository.UsersRepository;
//import com.project.blog.service.BlogService;
//import com.project.blog.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.security.Principal;
//
//@CrossOrigin()
//@RestController
//@RequestMapping("/comments")
//public class CommentController {
//    @Autowired
//    CommentRepository commentRepository;
//    @Autowired
//    private BlogService blogService;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    BlogRepository blogRepository;
//    @Autowired
//    UsersRepository usersRepository;
//
////    @PostMapping("/addcomment/{blog_id}/and/{user_id}")
////    public Comments addComment(@Valid @RequestBody Comments comments,@PathVariable Principal principal) {
////        return blogService.addBlog(userService.getUserrId(principal),comments);
////    }
//}
