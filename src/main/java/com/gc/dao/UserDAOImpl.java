package com.gc.dao;

import com.gc.models.UsersEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {

    private static SessionFactory factory;
    private static String msg;

    /**
     * @param newUser
     * @return
     */
    public Integer save(UsersEntity newUser) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        Integer id = (Integer) s.save(newUser);
        tx.commit();
        s.close();
        return id;
    }

    /**
     * @param firstName
     * @return
     */
    public Integer getUserID(String firstName) {
        Session s = getSession();
        Criteria c = s.createCriteria(UsersEntity.class);
        c.add(Restrictions.like("firstName", "Matt"));

        UsersEntity userInfo = (UsersEntity) c;
        s.close();

        return userInfo.getUserId();
    }

    /**
     * @param userID
     */
    public void deleteUser(int userID) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.delete(userID);

        tx.commit();
        s.close();
    }

    /**
     * @return
     */
    public ArrayList<UsersEntity> getAllUsers() {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        Criteria u = s.createCriteria(UsersEntity.class);

        tx.commit();
        //s.close();
        return (ArrayList<UsersEntity>) u.list();
    }


    /**
     * @param userName
     * @param password
     * @return
     */
    public UsersEntity getUser(String userName, String password) {
        UsersEntity user;
        Session s = getSession();
        user = (UsersEntity) s.createQuery("from UsersEntity where userName = '" + userName + "' and password= '" + password + "'").setMaxResults(1).uniqueResult();
        s.close();

        return user;
    }

    public UsersEntity checkRegistry(String userName, String email) {
        UsersEntity user;
        Session s = getSession();
        user = (UsersEntity) s.createQuery("from UsersEntity where userName = '" + userName + "' or email= '" + email + "'").setMaxResults(1).uniqueResult();
        s.close();

        return user;
    }



    /**
     * @return
     */

    private static Session getSession() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        return sessionFact.openSession();
    }

}


