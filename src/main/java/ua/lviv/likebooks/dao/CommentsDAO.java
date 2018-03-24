package ua.lviv.likebooks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lviv.likebooks.entity.Comments;
import ua.lviv.likebooks.entity.User;


public interface CommentsDAO extends JpaRepository<Comments,Integer> {

}

