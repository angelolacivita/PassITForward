package com.gc.models;

import javax.persistence.*;

/**
 * Created by angelo on 8/8/17.
 */
@Entity
@Table(name = "languages", schema = "PassITForward", catalog = "")
public class LanguagesEntity {
    private int languageId;
    private String language;

    @Id
    @Column(name = "languageID", nullable = false)
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
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

        if (languageId != that.languageId) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = languageId;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}
