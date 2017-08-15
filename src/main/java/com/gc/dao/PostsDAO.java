package com.gc.dao;

import com.gc.models.PostsEntity;
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
public interface PostsDAO {
    void save(PostsEntity newPost);

    ArrayList<PostsEntity> getAllPosts(Model model, int languageId);

    ArrayList<PostsEntity> getUserPosts(int userId);

    ArrayList<PostsEntity> getAllPosts();

    void deletePost(int postID);


}
