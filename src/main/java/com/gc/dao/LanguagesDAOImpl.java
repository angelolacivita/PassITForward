package com.gc.dao;

import com.gc.models.LanguagesEntity;
import com.gc.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;


public class LanguagesDAOImpl implements LanguagesDAO {
    private static SessionFactory sessionFactory;

    public LanguagesDAOImpl(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    /**
     * @return
     */
    public ArrayList<LanguagesEntity> getAllLanguages() {

        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        Criteria l = s.createCriteria(LanguagesEntity.class);

        tx.commit();
        //s.close();
        return (ArrayList<LanguagesEntity>) l.list();
    }


//    /**
//     * @return
//     */
//    private static Session getSession() {
//        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//        SessionFactory sessionFact = cfg.buildSessionFactory();
//        return sessionFact.openSession();
//    }


}
