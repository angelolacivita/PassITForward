package com.gc.models;

import javax.persistence.*;

/**
 * Created by angelo on 8/7/17.
 */
@Entity
@Table(name = "languages", schema = "PassITForward", catalog = "")
public class LanguagesEntity {
    private int languagesId;
    private String language;

    @Id
    @Column(name = "languagesID", nullable = false)
    public int getLanguagesId() {
        return languagesId;
    }

    public void setLanguagesId(int languagesId) {
        this.languagesId = languagesId;
    }

    @Basic
    @Column(name = "language", nullable = false, length = 45)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguagesEntity that = (LanguagesEntity) o;

        if (languagesId != that.languagesId) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = languagesId;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}
