package com.project.blog.controller;

import com.project.blog.model.Users;
import com.project.blog.repository.UsersRepository;
import com.project.blog.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersRepository userRepository;
    @Autowired
    UserService userService;
    @PostMapping("/addUser")
    public Users createUser(@Valid @RequestBody Users user) {
        user.setRole("user");
        user.setActive(1);
        return userRepository.save(user);
    }

    @GetMapping("/getall")
    public List<Users> getallusers() {
        return userRepository.findAll();
    }

    @GetMapping("/getbyid/{user_id}")
    public Users getbyid(@PathVariable Long user_id){
        return userRepository.findByUserId(user_id);
    }
    @GetMapping("/getuser")
    public Users getuserbyid(Principal principal) {
        return userService.getUserProfile(userService.getUserrId(principal),principal);
    }

    @PutMapping("/updateUser")
    public Users updateUser(Principal principal, @Valid @RequestBody Users userDetails) {

        Users user = userService.getUserProfile(userService.getUserrId(principal),principal);
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setName(userDetails.getName());
        Users updateduser = userRepository.save(user);
        return updateduser;
    }

}
