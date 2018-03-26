package ua.lviv.likebooks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.likebooks.entity.Like;


public interface LikeDAO  extends JpaRepository <Like, Integer> {
}
