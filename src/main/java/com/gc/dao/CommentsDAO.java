package com.gc.dao;

import com.gc.models.CommentsEntity;
import org.springframework.ui.Model;

import java.util.ArrayList;


public interface CommentsDAO {
    void save(CommentsEntity newComments);

    ArrayList<CommentsEntity> getAllComments(Model model, int postId);

    ArrayList<CommentsEntity> getUserComments(int userId);

    CommentsEntity commentCheck (int userId, int postId);

}
