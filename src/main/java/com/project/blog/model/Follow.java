package com.project.blog.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="Follow")
@EntityListeners(AuditingEntityListener.class)


public class Follow implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followId;

    @ManyToOne
    private Users users;

    @ManyToOne
    private Users following;

    @Column(name = "status")
    private int status;

    public Follow(Users users, Users following, int status) {
        this.users = users;
        this.following = following;
        this.status = status;
    }

    public Follow () {

    }
    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getFollowing() {
        return following;
    }

    public void setFollowing(Users following) {
        this.following = following;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
