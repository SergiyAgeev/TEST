package ua.lviv.likebooks.service;


import ua.lviv.likebooks.entity.Comments;
import ua.lviv.likebooks.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    Post findById(int id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(int id);

}
