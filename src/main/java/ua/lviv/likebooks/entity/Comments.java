package ua.lviv.likebooks.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob @Column(nullable = false)
    private String body;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User commentator;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Post post;

    private Date date = new Date();


    public Comments() {
    }



    public Comments(String body, User commentator, Date date) {
        this.body = body;
        this.commentator = commentator;
        this.date = date;

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getCommentator() {
        return commentator;
    }

    public void setCommentator(User commentator) {
        this.commentator = commentator;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", commentator=" + commentator +
                ", date=" + date +
                '}';
    }
}
