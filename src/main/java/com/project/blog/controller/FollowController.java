package com.project.blog.controller;

import com.project.blog.model.Blog;
import com.project.blog.model.Follow;
import com.project.blog.repository.FollowRepository;
import com.project.blog.service.FollowService;
import com.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    FollowRepository followRepository;
    @Autowired
    FollowService followService;
    @Autowired
    UserService userService;

    @GetMapping("/f/{user_id}")
    @ResponseBody
    public List<Blog> follow(@PathVariable Long user_id, Principal principal){
        return followService.follow(user_id,userService.getUserrId(principal),principal);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Follow> followList(Principal principal){
        return followService.list(userService.getUserrId(principal),principal);
    }

    @GetMapping("/following")
    @ResponseBody
    public int following(Principal principal){
        return followService.totalFollowing(userService.getUserrId(principal),principal);
    }
}
