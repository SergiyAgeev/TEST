package ua.lviv.likebooks.service;
import ua.lviv.likebooks.entity.Like;
import java.util.List;

public interface LikeService {

    void save(Like like);
    List<Like> findAll();
    void delete(int id);
    Like findById(int id);

}
