package ua.lviv.likebooks.service;



import ua.lviv.likebooks.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();
    User findByUserName(String name);
}
