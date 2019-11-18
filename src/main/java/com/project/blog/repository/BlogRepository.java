package com.project.blog.repository;

import com.project.blog.model.Blog;
import com.project.blog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    Blog findByBlogId(Long blog_id);
    List<Blog> findAllByUsersOrderByCreatedAt(Users users);
    List<Blog> findAllByStatus(int s);
    Blog findByBlogIdAndUsers(Long blogid, Users users);
    List<Blog> findAllByTitleContaining(String title);
}
