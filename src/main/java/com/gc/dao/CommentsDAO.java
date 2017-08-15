package com.gc.dao;

import com.gc.models.CommentsEntity;
import org.springframework.ui.Model;

import java.util.ArrayList;

/**
 * (Alphabetical Order)
 * <p>
 * Farha Hanif
 * https://github.com/fhanif
 * <p>
 * Angelo LaCivita
 * https://github.com/angelolacivita
 * <p>
 * Matthew Menna
 * https://github.com/mattmenna
 * https://www.linkedin.com/in/matthew-menna/
 */
public interface CommentsDAO {
    void save(CommentsEntity newComments);

    ArrayList<CommentsEntity> getAllComments(Model model, int postId);

    ArrayList<CommentsEntity> getUserComments(int userId);

    void deleteCommentsByUser(int userID);

    void deleteComment(int commentID);

}
