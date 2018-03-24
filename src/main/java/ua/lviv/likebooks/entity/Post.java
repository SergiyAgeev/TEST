package ua.lviv.likebooks.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob @Column(nullable = false)
    private String body;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User author;

    @OneToMany(mappedBy = "post", cascade=CascadeType.ALL)
    private Set<Comments> post = new HashSet<Comments>() {

    };


    private Date date = new Date();

    public Post() {
    }
    public Post(int id,String title, String body, User author, Date date) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.date = date;
    }

    public Post(String title, String body, User author, Date date) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Comments> getPost() {
        return post;
    }

    public void setPost(Set<Comments> post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }
}
