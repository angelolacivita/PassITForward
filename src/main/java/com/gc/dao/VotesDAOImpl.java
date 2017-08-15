package com.gc.dao;

import com.gc.models.VotesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by fhani on 8/15/2017.
 */
public class VotesDAOImpl implements VotesDAO {

    public void vote (int userId, int commentId, int votevalue){
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        VotesEntity vote = new VotesEntity();
        vote.setCommentId(commentId);
        vote.setUserId(userId);
        vote.setVoteValue(votevalue);


        s.save(vote);
        tx.commit();
        s.close();

    }




    private Session getSession() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        return sessionFact.openSession();
    }

}
