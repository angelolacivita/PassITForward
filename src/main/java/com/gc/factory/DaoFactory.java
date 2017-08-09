package com.gc.factory;


import com.gc.dao.*;

/**
 * Created by maurice on 7/20/17.
 * Factory to return concrete implementations of ProductDaos
 */
public class DaoFactory {
    public static final int USERS_HIBERNATE_DAO = 0;
    public static final int WALLET_HIBERNATE_DAO = 1;

    public static passITforwardDAO getDaoInstance(int fileDao) {
        switch(fileDao){
            case passITforwardDAO.FILE_DAO:
               // return new FileDao();

            case passITforwardDAO.JDBC_DAO:
                return null;

            default:
                break;
        }
        return null;
    }

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
}
