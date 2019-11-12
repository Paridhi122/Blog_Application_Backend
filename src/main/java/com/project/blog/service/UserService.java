package com.project.blog.service;

import com.project.blog.model.Users;
import com.project.blog.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersRepository userRepository;


    public Long getUserrId(Principal principal) {
        String username = principal.getName();
        return userRepository.findByUsername(username).get().getUserId();
    }

    public String getUserRole(Long user_id, Principal principal) {
        return  userRepository.findByUserId(user_id).getRole();//.getroleid();
    }

    public Users getUserProfile(Long userid, Principal principal) {
        return userRepository.findByUserId(userid);
    }

}
