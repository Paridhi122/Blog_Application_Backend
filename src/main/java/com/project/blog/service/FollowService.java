package com.project.blog.service;

import com.project.blog.model.Blog;
import com.project.blog.model.Follow;
import com.project.blog.model.Users;
import com.project.blog.repository.BlogRepository;
import com.project.blog.repository.FollowRepository;
import com.project.blog.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
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
        List<Blog> blogList = blogRepository.findAllByUsersOrderByCreatedAt(users);
        Users users1 = usersRepository.findByUserId(user_id);
        Follow follow = new Follow(users1,users,1);
        followRepository.save(follow);
        return blogList;
    }

    public List<List<Blog>> blog(Long user_id,Principal principal) {
        List<List<Blog>> blogList = new ArrayList<>() ;
        Users users1 = usersRepository.findByUserId(user_id);
        List<Follow> followList = followRepository.findAllByUsers(users1);
        for(Follow f: followList) {
            List<Blog> blogs = blogRepository.findAllByUsersOrderByCreatedAt(f.getFollowing());
            blogList.add(blogs);
        }
        return blogList;
    }

    public List<Follow> list(Long user_id, Principal principal){
        Users users = usersRepository.findByUserId(user_id);
        return followRepository.findAllByUsers(users);
    }


    public List<Follow> unfollowUser(Long f_id, Long user_id, Principal principal) {
        Follow follow =  followRepository.findFollowByFollowId(f_id);
        followRepository.delete(follow);
        Users users = usersRepository.findByUserId(user_id);
        return followRepository.findAllByUsers(users);
    }

    public List<Follow> followers(Long user_id, Principal principal) {
        List<Follow> followList = followRepository.findAllByFollowing_UserId(user_id);
        return followList;
    }

    public int status(Long f_id,Long user_id,Principal principal){
        Users users = usersRepository.findByUserId(user_id);
        Follow follow = followRepository.findByUsersAndFollowing_UserId(users,f_id);
        if(follow == null)
            return 0;
        else
            return follow.getStatus();
    }
}
