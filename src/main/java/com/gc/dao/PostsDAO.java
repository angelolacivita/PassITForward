package com.gc.dao;

import com.gc.models.PostsEntity;
import org.springframework.ui.Model;

import java.util.ArrayList;

/**
 * Created by angelo on 8/10/17.
 */
public interface PostsDAO {

    ArrayList<PostsEntity> getAllPosts(Model model, int languageId);

}
