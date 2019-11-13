package com.project.blog.repository;

import com.project.blog.model.Follow;
import com.project.blog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Long> {
    List<Follow> findAllByUsers(Users user);
    Follow findFollowByFollowId(Long f_id);
}
