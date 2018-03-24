package ua.lviv.likebooks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lviv.likebooks.entity.Comments;
import ua.lviv.likebooks.entity.Post;
import ua.lviv.likebooks.entity.User;

import java.util.List;

public interface PostDAO extends JpaRepository<Post, Integer>{
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.author ORDER BY p.date DESC")
    List<Post> findLatest5Posts();

}
