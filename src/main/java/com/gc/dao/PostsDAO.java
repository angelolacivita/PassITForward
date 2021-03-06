package com.gc.dao;

import com.gc.models.PostsEntity;
import org.springframework.ui.Model;

import java.util.ArrayList;


public interface PostsDAO {
    void save(PostsEntity newPost);

    ArrayList<PostsEntity> getAllPosts(Model model, int languageId);

    ArrayList<PostsEntity> getUserPosts(int userId);

    ArrayList<PostsEntity> getAllPosts();

    void deletePost(int postID);

}
