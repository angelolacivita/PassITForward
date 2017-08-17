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
import sun.security.tools.policytool.PolicyTool;

import java.util.ArrayList;


public class CommentsDAOImpl implements CommentsDAO {
    /**
     * @param newComments
     */
    public void save(CommentsEntity newComments) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.save(newComments);
        tx.commit();
        s.close();
    }

    /**
     * @return
     */
    private Session getSession() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        return sessionFact.openSession();
    }

    /**
     * @param model
     * @param postId
     * @return
     */
    public ArrayList<CommentsEntity> getAllComments(Model model, int postId) {

        Session s = getSession();
        Transaction tx = s.beginTransaction();
        PostsEntity temp = (PostsEntity) s.get(PostsEntity.class, postId);

        Criteria c = s.createCriteria(CommentsEntity.class);
        c.add(Restrictions.like("postId", postId));


        model.addAttribute("postId", temp.getPostId());
        model.addAttribute("postTitle", temp.getPostTitle());
        model.addAttribute("postDescription", temp.getPostDescription());

        //tx.commit();
        //s.close();

        return (ArrayList<CommentsEntity>) c.list();
    }

    /**
     * @param userId
     * @return
     */
    public ArrayList<CommentsEntity> getUserComments(int userId) {

        Session s = getSession();
        Transaction tx = s.beginTransaction();

        Criteria c = s.createCriteria(CommentsEntity.class);
        c.add(Restrictions.like("userId", userId));

        //tx.commit();
        //s.close();

        return (ArrayList<CommentsEntity>) c.list();
    }

    /**
     *
     * @param userId
     * @param postId
     * @return
     */
    public CommentsEntity commentCheck (int userId, int postId){

        CommentsEntity comment;
        Session s = getSession();
        comment = (CommentsEntity) s.createQuery("from CommentsEntity where userId = " + userId + " and postId= " + postId).setMaxResults(1).uniqueResult();
        s.close();

        return comment;
    }

}
