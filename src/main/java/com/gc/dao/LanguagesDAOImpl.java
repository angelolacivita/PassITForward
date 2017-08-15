package com.gc.dao;

import com.gc.models.LanguagesEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;


public class LanguagesDAOImpl implements LanguagesDAO {
    /**
     * @return
     */
    public ArrayList<LanguagesEntity> getAllLanguages() {

        Session s = getSession();
        Transaction tx = s.beginTransaction();
        Criteria l = s.createCriteria(LanguagesEntity.class);

        return (ArrayList<LanguagesEntity>) l.list();
    }

    /**
     * @param languageID
     */
    public void deleteLanguage(int languageID) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.delete(languageID);

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


}
