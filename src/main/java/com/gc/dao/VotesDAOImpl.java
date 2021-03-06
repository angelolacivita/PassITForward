package com.gc.dao;

import com.gc.models.UsersEntity;
import com.gc.models.VotesEntity;
import com.gc.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fhani on 8/15/2017.
 */
public class VotesDAOImpl implements VotesDAO {
    private static SessionFactory sessionFactory;

    public VotesDAOImpl(){
        sessionFactory = HibernateUtil.getSessionFactory();

    }
    /**
     *
     * @param userId
     * @param commentId
     * @param votevalue
     */
    public void vote(int userId, int commentId, int votevalue) {
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        VotesEntity vote = new VotesEntity();
        vote.setCommentId(commentId);
        vote.setUserId(userId);
        vote.setVoteValue(votevalue);

        s.save(vote);
        tx.commit();
        //s.close();
    }

    /**
     *
     * @param userId
     * @param commentsId
     * @return
     */
    public VotesEntity voteCheck(int userId, int commentsId) {
        VotesEntity voter;
        Session s = sessionFactory.openSession();
        voter = (VotesEntity) s.createQuery("from VotesEntity where userId = " + userId + " and commentId= " + commentsId).setMaxResults(1).uniqueResult();
        //s.close();

        return voter;

    }

    /**
     *
     * @return
     */
    public Map totalVotes() {
        Map<String, String> votesMap = new HashMap<String, String>();
        Session s = sessionFactory.openSession();
        // System.out.println(commentsId);
        List<Object[]> totalVotes = s.createSQLQuery("SELECT commentID,SUM(voteValue) FROM votes GROUP BY commentID")
                .list();
        for (Object[] row : totalVotes) {
            votesMap.put(row[0].toString(), row[1].toString());
            System.out.println(row[0].toString() + "," + row[1].toString());
        }

        //s.close();
        return votesMap;
    }
//
//    /**
//     *
//     * @return
//     */
//    private static Session getSession() {
//        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//        SessionFactory sessionFact = cfg.buildSessionFactory();
//        return sessionFact.openSession();
//    }

}
