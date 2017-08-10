package com.gc.dao;

import com.gc.models.LanguagesEntity;
import com.gc.models.PostsEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.ui.Model;

import java.util.ArrayList;

/**
 * Created by angelo on 8/10/17.
 */

public class PostsDAOImpl implements PostsDAO{

    public ArrayList<PostsEntity> getAllPosts(Model model, int languageId) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session s = sessionFact.openSession();
        Transaction tx = s.beginTransaction();

        LanguagesEntity temp = (LanguagesEntity) s.get(LanguagesEntity.class, languageId);
        model.addAttribute("language", temp.getLanguage());

        Criteria p = s.createCriteria(PostsEntity.class);
        p.add(Restrictions.like("languageId", languageId));
        return (ArrayList<PostsEntity>) p.list();
    }


}
