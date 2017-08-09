package com.gc.dao;

import com.gc.models.CommentsEntity;

public interface CommentsDAO {
    Integer save(CommentsEntity newComments);
}
