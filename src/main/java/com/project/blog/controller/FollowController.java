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
import java.util.Optional;

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

    @GetMapping("/getbloglist")
    @ResponseBody
    public List<List<Blog>> blogList(Principal principal){
        return followService.blog(userService.getUserrId(principal),principal);
    }

    @GetMapping(value = "/unfollow/{f_id}")
    @ResponseBody
    public List<Follow> unfollow(@PathVariable Long f_id, Principal principal) {
        return followService.unfollowUser(f_id,userService.getUserrId(principal),principal);
    }

    @GetMapping(value = "/followers")
    @ResponseBody
    public List<Follow> followers(Principal principal) {
        return followService.followers(userService.getUserrId(principal),principal);
    }


    @GetMapping(value = "/status/{user_id}")
    @ResponseBody
    public int status(@PathVariable Long user_id, Principal principal) {
        return followService.status(user_id,userService.getUserrId(principal),principal);
    }
}
