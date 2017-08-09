package com.gc.dao;

import com.gc.models.CommentsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CommentsDAOImpl implements CommentsDAO {

    public Integer save(CommentsEntity newComments) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session s = sessionFact.openSession();
        Transaction tx = s.beginTransaction();

        Integer id = (Integer) s.save(newComments);

        tx.commit();
        s.close();
        return id;
    }

    ;
}
