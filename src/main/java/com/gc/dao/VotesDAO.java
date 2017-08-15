package com.gc.dao;

import com.gc.models.VotesEntity;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by fhani on 8/15/2017.
 */
public interface VotesDAO {

    void vote (int userId, int commentId, int votevalue);
    VotesEntity voteCheck (int userId, int commentsId);
    Map totalVotes ();


}
