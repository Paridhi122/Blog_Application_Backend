package com.project.blog.service;

import com.project.blog.model.Blog;
import com.project.blog.model.Follow;
import com.project.blog.model.Users;
import com.project.blog.repository.BlogRepository;
import com.project.blog.repository.FollowRepository;
import com.project.blog.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.security.Principal;
import java.util.List;

@Service
public class FollowService {
    @Autowired
    FollowRepository followRepository;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UsersRepository usersRepository;

    public List<Blog> follow(Long f_id, Long user_id, Principal principal) {
        Users users = usersRepository.findByUserId(f_id);
        List<Blog> blogList = blogRepository.findAllByUsersAndStatus(users,1);
        Users users1 = usersRepository.findByUserId(user_id);
        Follow follow = new Follow(users1,users);
        followRepository.save(follow);
        return blogList;
    }

    public List<Follow> list(Long user_id, Principal principal){
        Users users = usersRepository.findByUserId(user_id);
        return followRepository.findAllByUsers(users);
    }

    public int totalFollowing(Long user_id, Principal principal){
        int count = 0;
        Users users = usersRepository.findByUserId(user_id);
        List<Follow> followList = followRepository.findAllByUsers(users);
        for(Follow f: followList) {
            count++;
        }
        return count;
    }

}
