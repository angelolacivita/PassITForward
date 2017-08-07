package com.gc.models;

import javax.persistence.*;

/**
 * Created by angelo on 8/7/17.
 */
@Entity
@Table(name = "comments", schema = "PassITForward", catalog = "")
public class CommentsEntity {
    private int commentsId;
    private String commentDescription;

    @Id
    @Column(name = "commentsID", nullable = false)
    public int getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(int commentsId) {
        this.commentsId = commentsId;
    }

    @Basic
    @Column(name = "commentDescription", nullable = true, length = -1)
    public String getCommentDescription() {
        return commentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentsEntity that = (CommentsEntity) o;

        if (commentsId != that.commentsId) return false;
        if (commentDescription != null ? !commentDescription.equals(that.commentDescription) : that.commentDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentsId;
        result = 31 * result + (commentDescription != null ? commentDescription.hashCode() : 0);
        return result;
    }
}
