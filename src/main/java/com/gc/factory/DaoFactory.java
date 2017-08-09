package com.gc.factory;
import com.gc.dao.UserDAO;
import com.gc.dao.UserDAOImpl;

import com.gc.dao.*;
import com.gc.models.CommentsEntity;

/**
 * Created by maurice on 7/20/17.
 * Factory to return concrete implementations of ProductDaos
 */
public class DaoFactory {
    public static final int USERS_HIBERNATE_DAO = 0;
    public static final int WALLET_HIBERNATE_DAO = 1;
    public static final int COMMENTS_HIBERNATE_DAO = 1;

    public static UserDAO getUserDaoInstance(int usersHibernateDao) {
        switch(usersHibernateDao){
            case USERS_HIBERNATE_DAO:
                return new UserDAOImpl();

            default:
                break;
        }
        return null;
    }

    public static WalletDAO getWalletDaoInstance(int walletHibernateDao) {
        switch(walletHibernateDao){
            case WALLET_HIBERNATE_DAO:
                return new WalletDAOImpl();

            default:
                break;
        }
        return null;
    }

    public static CommentsDAO getCommentsDaoInstance(int commentsHibernateDao){
        switch(commentsHibernateDao){
            case COMMENTS_HIBERNATE_DAO:
                return new CommentsDAOImpl();

            default:
                break;
        }
        return null;
    }
}

