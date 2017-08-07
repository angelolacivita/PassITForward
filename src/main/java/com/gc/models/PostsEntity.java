package com.gc.models;

import javax.persistence.*;

/**
 * Created by angelo on 8/7/17.
 */
@Entity
@Table(name = "posts", schema = "PassITForward", catalog = "")
public class PostsEntity {
    private int postId;
    private String postTitle;
    private String postDescription;

    @Id
    @Column(name = "postID", nullable = false)
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "postTitle", nullable = false, length = 255)
    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    @Basic
    @Column(name = "postDescription", nullable = false, length = -1)
    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostsEntity that = (PostsEntity) o;

        if (postId != that.postId) return false;
        if (postTitle != null ? !postTitle.equals(that.postTitle) : that.postTitle != null) return false;
        if (postDescription != null ? !postDescription.equals(that.postDescription) : that.postDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId;
        result = 31 * result + (postTitle != null ? postTitle.hashCode() : 0);
        result = 31 * result + (postDescription != null ? postDescription.hashCode() : 0);
        return result;
    }
}
