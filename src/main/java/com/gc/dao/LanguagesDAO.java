package com.gc.dao;

import com.gc.models.LanguagesEntity;

import java.util.ArrayList;

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
public interface LanguagesDAO {
    ArrayList<LanguagesEntity> getAllLanguages();

    void deleteLanguage(int languageID);

}
