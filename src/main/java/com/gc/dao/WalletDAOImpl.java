package com.gc.dao;

import com.gc.models.WalletEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class WalletDAOImpl implements WalletDAO {
    public Integer save(WalletEntity newWallet) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session s = sessionFact.openSession();
        Transaction tx = s.beginTransaction();

        Integer id = (Integer) s.save(newWallet);

        tx.commit();
        s.close();
        return id;
    }
}
