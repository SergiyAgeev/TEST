package ua.lviv.likebooks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.likebooks.dao.LikeDAO;
import ua.lviv.likebooks.entity.Like;
import ua.lviv.likebooks.service.LikeService;

import java.util.List;
@Service
@Transactional
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeDAO lDAO;


    @Override
    public void save(Like like) {
         lDAO.save(like);
    }

    @Override
    public List<Like> findAll() {
        return lDAO.findAll();
    }

    @Override
    public void delete(int id) {
         lDAO.delete(id);
    }
}
