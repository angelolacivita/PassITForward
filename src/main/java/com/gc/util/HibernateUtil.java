package com.gc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by jayme on 8/11/2017.
 */
public class HibernateUtil {
    private static SessionFactory factory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();

        return sessionFact;
    }

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {

        return factory;
    }
}