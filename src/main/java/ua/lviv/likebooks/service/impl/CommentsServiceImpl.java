package ua.lviv.likebooks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.likebooks.dao.CommentsDAO;
import ua.lviv.likebooks.entity.Comments;
import ua.lviv.likebooks.entity.Post;
import ua.lviv.likebooks.service.CommentsService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsDAO cDAO;

    private List<Comments> comments = new ArrayList<Comments>() {};


    @Override
    public Comments save(Comments comments) {
        this.comments.add(comments);
        cDAO.save(comments);
        return comments;
    }

    @Override
    public List<Comments> findAll() {
        return cDAO.findAll();
    }

    @Override
    public Comments findOne(int id) {
        return cDAO.findOne(id);
    }

    @Override
    public void delete(int id) {

    }



//    @Override
//    public Comments findByPostTitle(String title) {
//        return cDAO.findByPostTitle(title);
//    }
}
