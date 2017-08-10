package com.gc.dao;

import com.gc.models.CommentsEntity;
import com.gc.models.PostsEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.ui.Model;

import java.util.ArrayList;

public class CommentsDAOImpl implements CommentsDAO {

    public Integer save(CommentsEntity newComments) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        Integer id = (Integer) s.save(newComments);
        tx.commit();
        s.close();
        return id;
    }

    public void deleteCommentsByUser(int userID) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.delete(userID);

        tx.commit();
        s.close();
    }

    public void deleteComment(int commentID) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.delete(commentID);

        tx.commit();
        s.close();
    }

    private Session getSession() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        return sessionFact.openSession();
    }

    public ArrayList<CommentsEntity> commentsList(Model model, int postId) {

        Session s = getSession();
        Transaction tx = s.beginTransaction();

        Criteria c = s.createCriteria(CommentsEntity.class);
        c.add(Restrictions.like("postId", postId));

        PostsEntity temp = (PostsEntity) s.get(PostsEntity.class, postId);

        model.addAttribute("postTitle", temp.getPostTitle());
        model.addAttribute("postDescription", temp.getPostDescription());

        return (ArrayList<CommentsEntity>) c.list();
    }


}
