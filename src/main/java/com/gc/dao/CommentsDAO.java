package com.gc.dao;

import com.gc.models.CommentsEntity;

public interface CommentsDAO {
    Integer save(CommentsEntity newComments);
    void deleteCommentsByUser(int userID);
    void deleteComment(int commentID);

}
