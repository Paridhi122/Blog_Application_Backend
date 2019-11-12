package com.project.blog.service;

import com.project.blog.model.Blog;
import com.project.blog.model.Users;
import com.project.blog.repository.BlogRepository;
import com.project.blog.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;


@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UsersRepository usersRepository;

    public Blog addBlog(Long user_id,Blog blog) {
        Users users = usersRepository.findByUserId(user_id);
        blog.setUsers(users);
        blog.setCreatedAt();
        blog.setUpdatedAt();
        return blogRepository.save(blog);
    }

    public List<Blog> showBlog(Long user_id, Principal principal){
        Users users = usersRepository.findByUserId(user_id);
        return blogRepository.findAllByUsers(users);
    }

    public List<Blog> deleteBlogs(Long userid, Long blogid) {
        Users users = usersRepository.findByUserId(userid);
        Blog blog = blogRepository.findByBlogIdAndUsers(blogid,users);
        blogRepository.delete(blog);
        return blogRepository.findAllByUsers(users);
    }

    public Blog update(Long user_id,Principal principal, Blog updated,Long blog_id){
        Users users = usersRepository.findByUserId(user_id);
        Blog blog = blogRepository.findByBlogIdAndUsers(blog_id,users);
        blog.setUpdatedAt();
        blog.setCategory(updated.getCategory());
        blog.setTitle(updated.getTitle());
        blog.setContent(updated.getContent());
        return blogRepository.save(blog);
    }


}
