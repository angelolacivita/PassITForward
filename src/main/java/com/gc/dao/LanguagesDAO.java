package com.gc.dao;

import com.gc.models.LanguagesEntity;

import java.util.ArrayList;


public interface LanguagesDAO {
    ArrayList<LanguagesEntity> getAllLanguages();

    void deleteLanguage(int languageID);

}
