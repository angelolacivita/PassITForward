package com.gc.dao;

import com.gc.models.WalletEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import java.util.ArrayList;

/**
 * (Alphabetical Order)
 * <p>
 * Farha Hanif
 * https://github.com/fhanif
 * <p>
 * Angelo LaCivita
 * https://github.com/angelolacivita
 * <p>
 * Matthew Menna
 * https://github.com/mattmenna
 * https://www.linkedin.com/in/matthew-menna/
 */
public class WalletDAOImpl implements WalletDAO {
    public Integer save(WalletEntity newWallet) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();

        Integer id = (Integer) s.save(newWallet);

        tx.commit();
        s.close();
        return id;
    }

    public int getWallet(int userId) {
        Session s = getSession();
        Criteria w = s.createCriteria(WalletEntity.class);
        w.add(Restrictions.like("userId", userId));
        ArrayList<WalletEntity> wallet = (ArrayList<WalletEntity>) w.list();
        int currentBalance = wallet.get(0).getWalletValue();

        return currentBalance;
    }

    public void deleteWalletID(int walletID) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.delete(walletID);

        tx.commit();
        s.close();
    }

    public void creditToWallet(int credit, int userId) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();

        Criteria w = s.createCriteria(WalletEntity.class);
        w.add(Restrictions.eq("userId", userId));
        ArrayList<WalletEntity> wallet = (ArrayList<WalletEntity>) w.list();
        int currentBalance = wallet.get(0).getWalletValue();
        wallet.get(0).setWalletValue(currentBalance + credit);

        tx.commit();
        s.close();

    }

    public void debitFromWallet(int debit, int userId) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();

        Criteria w = s.createCriteria(WalletEntity.class);
        w.add(Restrictions.eq("userId", userId));
        ArrayList<WalletEntity> wallet = (ArrayList<WalletEntity>) w.list();
        int currentBalance = wallet.get(0).getWalletValue();
        wallet.get(0).setWalletValue(currentBalance - debit);

        tx.commit();
        s.close();
    }

    private Session getSession() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        return sessionFact.openSession();
    }
}
