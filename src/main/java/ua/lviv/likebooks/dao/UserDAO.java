package ua.lviv.likebooks.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lviv.likebooks.entity.User;

public interface UserDAO extends JpaRepository<User,Integer>{
    @Query("from User u where u.username=:username")
    User findByUserName(@Param("username") String name);
}
