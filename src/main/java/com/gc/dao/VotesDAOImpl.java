package com.gc.dao;

import com.gc.models.UsersEntity;
import com.gc.models.VotesEntity;
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

    public VotesEntity voteCheck (int userId, int commentsId) {
        VotesEntity voter;
        Session s = getSession();
        voter = (VotesEntity) s.createQuery("from VotesEntity where userId = " + userId + " and commentId= " + commentsId).setMaxResults(1).uniqueResult();
        s.close();

        return voter;

    }

    public Map totalVotes() {
        Map <String, String> votesMap = new HashMap<String, String>();
        Session s = getSession();
       // System.out.println(commentsId);
        List<Object[]> totalVotes = s.createSQLQuery("SELECT commentID,SUM(voteValue) FROM votes GROUP BY commentID")
                .list();
        for (Object[] row: totalVotes) {
            votesMap.put(row[0].toString(), row[1].toString());
            System.out.println(row[0].toString()+ "," + row[1].toString());

        }


        return votesMap;
//        Session s = getSession();
//        System.out.println(commentsId);
//        ArrayList <Integer[]> totalVotes = (ArrayList)s.createSQLQuery("SELECT sum(votes.voteValue), votes.commentID from comments inner join votes on comments.commentsID = votes.commentID and comments.commentsID = " + commentsId)
//                .addScalar("sum(votes.voteValue)", Hibernate.INTEGER)
//                .addScalar("commentID", Hibernate.INTEGER)
//                .list();
//        System.out.println((totalVotes.get(0)));
//
//        return totalVotes;


//                SELECT sum(votes.voteValue), votes.commentID
//        FROM comments
//        INNER JOIN votes ON comments.commentsID = votes.commentID AND comments.commentsID = 8;
    }



    private Session getSession() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        return sessionFact.openSession();
    }

}
