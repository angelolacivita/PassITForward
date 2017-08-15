package com.gc.models;

import javax.persistence.*;

/**
 * Created by fhani on 8/15/2017.
 */
@Entity
@Table(name = "votes", schema = "PassITForward", catalog = "")
public class VotesEntity {
    private Integer userId;
    private int voteId;
    private Integer voteValue;
    private Integer commentId;

    @Basic
    @Column(name = "userID", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "voteID", nullable = false)
    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    @Basic
    @Column(name = "voteValue", nullable = true)
    public Integer getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(Integer voteValue) {
        this.voteValue = voteValue;
    }

    @Basic
    @Column(name = "commentID", nullable = true)
    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotesEntity that = (VotesEntity) o;

        if (voteId != that.voteId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (voteValue != null ? !voteValue.equals(that.voteValue) : that.voteValue != null) return false;
        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + voteId;
        result = 31 * result + (voteValue != null ? voteValue.hashCode() : 0);
        result = 31 * result + (commentId != null ? commentId.hashCode() : 0);
        return result;
    }
}
