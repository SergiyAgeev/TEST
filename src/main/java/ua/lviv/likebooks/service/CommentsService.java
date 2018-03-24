package ua.lviv.likebooks.service;

import ua.lviv.likebooks.entity.Comments;
import ua.lviv.likebooks.entity.User;


import java.util.List;

public interface CommentsService {

        Comments save(Comments comments);
        List<Comments> findAll();
        Comments findOne(int id);
        void delete(int id);

    }

