package com.gc.dao;

import com.gc.models.LanguagesEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by angelo on 8/10/17.
 */
public class LanguagesDAOImpl implements LanguagesDAO {

    public ArrayList<LanguagesEntity> getAllLanguages() {

        Session s = getSession();
        Transaction tx = s.beginTransaction();
        Criteria l = s.createCriteria(LanguagesEntity.class);

        return (ArrayList<LanguagesEntity>) l.list();
    }

    public void deleteLanguage(int languageID) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.delete(languageID);

        tx.commit();
        s.close();
    }

    private Session getSession() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        return sessionFact.openSession();
    }


}
