package ua.lviv.likebooks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.likebooks.dao.UserDAO;
import ua.lviv.likebooks.entity.User;
import ua.lviv.likebooks.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService {
    @Autowired
    private UserDAO dao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void save(User user) {
        String encodepassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodepassword);
        dao.save(user);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User findByUserName(String username) {
        return dao.findByUserName(username);
    }

    @Override
    public User findOne(int id) {
        return dao.findOne(id);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUserName(username);
    }
}
