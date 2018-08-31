package ua.lviv.likebooks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lviv.likebooks.entity.Like;
import ua.lviv.likebooks.entity.Post;
import ua.lviv.likebooks.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public interface LikeDAO extends JpaRepository<Like, Integer> {


}
