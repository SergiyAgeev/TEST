package ua.lviv.likebooks.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User userId;


    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Post postId;


    @Column(name = "likes")
    @Type(type="yes_no")
    private boolean likes;



    public Like() {
    }

    public Like(User userId, Post postId, boolean likes) {
        this.userId = userId;
        this.postId = postId;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }




    public boolean isLikes() {
        return likes;
    }

    public void setLikes(boolean likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Like{" +
                "userId=" + userId +
                ", postId=" + postId +
                ", likes='" + likes + '\'' +
                '}';
    }
}
