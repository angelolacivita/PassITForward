package com.gc.dao;

import com.gc.models.UsersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDAOImpl implements UserDAO {
    public Integer save(UsersEntity newUser) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session s = sessionFact.openSession();
        Transaction tx = s.beginTransaction();

        Integer id = (Integer) s.save(newUser);

        tx.commit();
        s.close();

        return id;
    }
}
