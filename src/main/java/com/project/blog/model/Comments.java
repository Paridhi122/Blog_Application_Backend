//package com.project.blog.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name="Comments")
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
//        allowGetters = true)
//
//public class Comments {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long commentId;
//
//    @ManyToOne
//    private Users users;
//
//    @ManyToOne
//    private Blog blogs;
//
//    @Column(name = "date")
//    private LocalDate date;
//
//    public Comments(Users users, Blog blogs, LocalDate date) {
//        this.users = users;
//        this.blogs = blogs;
//        this.date = date;
//    }
//
//    public Comments() {
//
//    }
//
//    public Long getCommentId() {
//        return commentId;
//    }
//
//    public void setCommentId(Long commentId) {
//        this.commentId = commentId;
//    }
//
//    public Users getUsers() {
//        return users;
//    }
//
//    public void setUsers(Users users) {
//        this.users = users;
//    }
//
//    public Blog getBlogs() {
//        return blogs;
//    }
//
//    public void setBlogs(Blog blogs) {
//        this.blogs = blogs;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//}
