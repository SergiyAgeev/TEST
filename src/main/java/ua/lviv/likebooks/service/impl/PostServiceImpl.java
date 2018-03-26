package ua.lviv.likebooks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.likebooks.dao.PostDAO;
import ua.lviv.likebooks.entity.Comments;
import ua.lviv.likebooks.entity.Post;
import ua.lviv.likebooks.entity.User;
import ua.lviv.likebooks.service.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDAO pdao;

    private List<Post> posts = new ArrayList<Post>() {
        {
            add(new Post("Some Title", "First Post", new User("pidar228@mail.com", "ivan"), null));
            add(new Post("TWO", "Second boring post", new User("sergiyageev@gmail.com", "serj"), null));
            add(new Post("3", "Post #3", new User("sergiyageev@gmail.com", "serj"), null));
            add(new Post("4", "Forth Post", new User("pidar228@mail.com", "ivan"), null));
            add(new Post("5", "Post Number 5", new User("sergiyageev@gmail.com", "serj"), null));
            add(new Post("7", "Sixth Post", new User("pidar228@mail.com", "ivan"), null));
        }
    };


    @Override
    public List<Post> findAll() {
        return pdao.findAll();
    }

    @Override
    public List<Post> findLatest5() {
        return this.pdao.findLatest5Posts();
    }


    @Override
    public Post findById(int id) {
        return pdao.findOne(id);
    }

    @Override
    public Post create(Post post) {
        this.posts.add(post);
        pdao.save(post);
        return post;
    }

    @Override
    public Post edit(Post post) {
        for (int i = 0; i < this.posts.size(); i++) {
            if (Objects.equals(this.posts.get(i).getId(), post.getId())) {
                this.posts.set(i, post);
                return post;
            }
        }
        throw new RuntimeException("Post not found: " + post.getId());
    }


    @Override
    public void deleteById(int id) {
        pdao.delete(id);

    }


}
