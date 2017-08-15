package com.gc.factory;

import com.gc.dao.UserDAO;
import com.gc.dao.UserDAOImpl;

import com.gc.dao.*;
import com.gc.models.CommentsEntity;
import org.apache.commons.codec.language.bm.Languages;

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

public class DaoFactory {
    public static final int USERS_HIBERNATE_DAO = 0;
    public static final int WALLET_HIBERNATE_DAO = 1;
    public static final int COMMENTS_HIBERNATE_DAO = 2;
    public static final int POSTS_HIBERNATE_DAO = 3;
    public static final int LANGUAGES_HIBERNATE_DAO = 4;

    public static UserDAO getUserDaoInstance(int usersHibernateDao) {
        switch (usersHibernateDao) {
            case USERS_HIBERNATE_DAO:
                return new UserDAOImpl();

            default:
                break;
        }
        return null;
    }


    public static WalletDAO getWalletDaoInstance(int walletHibernateDao) {
        switch (walletHibernateDao) {
            case WALLET_HIBERNATE_DAO:
                return new WalletDAOImpl();

            default:
                break;
        }
        return null;
    }

    public static CommentsDAO getCommentsDaoInstance(int commentsHibernateDao) {
        switch (commentsHibernateDao) {
            case COMMENTS_HIBERNATE_DAO:
                return new CommentsDAOImpl();

            default:
                break;
        }
        return null;
    }

    public static PostsDAO getPostsDaoInstance(int postsHibernateDao) {
        switch (postsHibernateDao) {
            case POSTS_HIBERNATE_DAO:
                return new PostsDAOImpl();

            default:
                break;
        }
        return null;
    }

    public static LanguagesDAO getLanguagesDaoInstance(int languagesHibernateDao) {
        switch (languagesHibernateDao) {
            case LANGUAGES_HIBERNATE_DAO:
                return new LanguagesDAOImpl();

            default:
                break;
        }
        return null;
    }
}

