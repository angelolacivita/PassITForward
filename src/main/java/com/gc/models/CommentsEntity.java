package com.gc.models;

import javax.persistence.*;

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

@Entity
@Table(name = "comments", schema = "PassITForward", catalog = "")
public class CommentsEntity {
    private int userId;
    private int postId;
    private int commentsId;
    private String commentDescription;

    @Basic
    @Column(name = "userID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "postID", nullable = false)
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

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

        if (userId != that.userId) return false;
        if (postId != that.postId) return false;
        if (commentsId != that.commentsId) return false;
        if (commentDescription != null ? !commentDescription.equals(that.commentDescription) : that.commentDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + postId;
        result = 31 * result + commentsId;
        result = 31 * result + (commentDescription != null ? commentDescription.hashCode() : 0);
        return result;
    }
}
