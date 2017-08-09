//package com.gc.factory;
//
//import com.gc.dao.FileDao;
//import com.gc.dao.JDBCDao;
//import com.gc.dao.passITforwardDAO;
//
///**
// * Created by maurice on 7/20/17.
// * Factory to return concrete implementations of ProductDaos
// */
//public class DaoFactory {
//    public static passITforwardDAO getDaoInstance(int fileDao) {
//        switch(fileDao){
//            case passITforwardDAO.FILE_DAO:
//                return new FileDao();
//
//            case passITforwardDAO.JDBC_DAO:
//                return new JDBCDao();
//
//            default:
//                break;
//        }
//        return null;
//    }
//}
