package com.gc.dao;

import com.gc.models.WalletEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;


public class WalletDAOImpl implements WalletDAO {
    /**
     * @param newWallet
     * @return
     */
    public Integer save(WalletEntity newWallet) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();

        Integer id = (Integer) s.save(newWallet);

        tx.commit();
        s.close();
        return id;
    }

    /**
     * @param userId
     * @return
     */
    public int getWallet(int userId) {
        Session s = getSession();
        Criteria w = s.createCriteria(WalletEntity.class);
        w.add(Restrictions.like("userId", userId));
        ArrayList<WalletEntity> wallet = (ArrayList<WalletEntity>) w.list();
        int currentBalance = wallet.get(0).getWalletValue();


        s.close();
        return currentBalance;


    }

    /**
     * @param walletID
     */
    public void deleteWalletID(int walletID) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.delete(walletID);

        tx.commit();
        s.close();
    }

    /**
     * @param credit
     * @param userId
     */
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

    /**
     * @param debit
     * @param userId
     */
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

    /**
     * @return
     */
    private Session getSession() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        return sessionFact.openSession();
    }
}
