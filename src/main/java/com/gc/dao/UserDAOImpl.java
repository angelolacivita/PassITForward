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
import java.util.List;

public class UserDAOImpl implements UserDAO {

    public Integer save(UsersEntity newUser) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        Integer id = (Integer) s.save(newUser);
        tx.commit();
        s.close();
        return id;
    }

    public Integer getUserID(String firstName){
        Session s = getSession();
        Criteria c = s.createCriteria(UsersEntity.class);
        c.add(Restrictions.like("firstName", "Matt"));

        UsersEntity userInfo = (UsersEntity) c;

        return userInfo.getUserId();
    }

    public void deleteUser(int userID) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.delete(userID);

        tx.commit();
        s.close();
    }

    public boolean checkUser(String userName, String password) {
//        Session s = getSession();
//
//        Criteria c = s.createCriteria(UsersEntity.class);
//        ;
//
//        ArrayList<UsersEntity> checkuserarray = (ArrayList<UsersEntity>) c.list();
//
//        if(c.add(Restrictions.like("userName", userName))){
//            return true;
//        }
        return false;

        //return (ArrayList<UsersEntity>) c.list();
//        UsersEntity checkUserInfo = (UsersEntity) c;

//        if(checkUserInfo.getUserName().equals(userName) && checkUserInfo.getPassword().equals(password)){
//         return true;
//        }
//
//        return false;
    }


    private Session getSession() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        return sessionFact.openSession();
    }

}
