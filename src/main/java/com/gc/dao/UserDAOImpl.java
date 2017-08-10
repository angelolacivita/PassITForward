package com.gc.dao;

import com.gc.models.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {

    public Integer save(UsersEntity newUser) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();

        Integer id = (Integer) s.save(newUser);

        tx.commit();
        s.close();

        return id;
    }

    private Session getSession() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        return sessionFact.openSession();
    }

    public Integer getUserID(String firstName){
        Session s = getSession();
        Criteria c = s.createCriteria(UsersEntity.class);
        c.add(Restrictions.like("firstName", "Matt"));

        UsersEntity userInfo = (UsersEntity) c;

        return userInfo.getUserId();
    }

}
