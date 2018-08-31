package ua.lviv.likebooks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.likebooks.dao.LikeDAO;
import ua.lviv.likebooks.entity.Like;
import ua.lviv.likebooks.entity.Post;
import ua.lviv.likebooks.entity.User;
import ua.lviv.likebooks.service.LikeService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class LikeServiceImpl implements LikeService {
    @PersistenceContext
    private EntityManager manager ;
    @Autowired
    private LikeDAO lDAO;



    @Override
    public void save(Like like) {
         lDAO.save(new Like());
    }

    @Override
    public List<Like> findAll() {
        return lDAO.findAll();
    }

    @Override
    public void delete(int id) {
         lDAO.delete(id);
    }

    @Override
    public Like findById(int id) {
        return lDAO.findOne(id);
    }




}
