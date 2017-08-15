package com.gc.dao;

import com.gc.models.UsersEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {

    private static SessionFactory factory;
    private static String msg;

    /**
     * @param newUser
     * @return
     */
    public Integer save(UsersEntity newUser) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        Integer id = (Integer) s.save(newUser);
        tx.commit();
        s.close();
        return id;
    }

    /**
     * @param firstName
     * @return
     */
    public Integer getUserID(String firstName) {
        Session s = getSession();
        Criteria c = s.createCriteria(UsersEntity.class);
        c.add(Restrictions.like("firstName", "Matt"));

        UsersEntity userInfo = (UsersEntity) c;

        return userInfo.getUserId();
    }

    /**
     * @param userID
     */
    public void deleteUser(int userID) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.delete(userID);

        tx.commit();
        s.close();
    }

    /**
     * @return
     */
    public static ArrayList<UsersEntity> getAllUsers() {
        Session session = factory.openSession();
        Transaction tx = null;
        ArrayList<UsersEntity> users = new ArrayList<UsersEntity>();
        try {
            tx = session.beginTransaction();
            users = (ArrayList<UsersEntity>) session.createQuery("FROM UsersEntity ").list();
            tx.commit();  //COMMIT MUST COME AFTER THE ACTION
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }
//
//    public static UsersEntity getUser(String username, String password) {
//        ArrayList<UsersEntity> users = getAllUsers();
//        boolean isUser = false;
//        for( UsersEntity user : users){
//            if (isUserNameEquals(username, user)) {
//                isUser = true;
//                if (isPasswordEquals(password, user)) {
//                    return user;
//                } else {
//                    msg = "Wrong Password!";
//                }
//            }
//        }
//        if (!isUser) {
//            msg = "User does not exist, please register";
//        }
//        return null;
//    }

    /**
     * @param userName
     * @param password
     * @return
     */
    public UsersEntity getUser(String userName, String password) {
        UsersEntity user;
        Session s = getSession();
        user = (UsersEntity) s.createQuery("from UsersEntity where userName = '" + userName + "' and password= '" + password + "'").setMaxResults(1).uniqueResult();
        s.close();

        return user;
    }

//    private static boolean isPasswordEquals(String password, UsersEntity user) {
//        return user.getPassword().equals(password);
//    }
//
//    private static boolean isUserNameEquals(String userName, UsersEntity user) {
//        return user.getUserName().equals(userName);
//    }
//
//

    /**
     * @return
     */

    private Session getSession() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        return sessionFact.openSession();
    }

}


//    public ArrayList<UsersEntity> getAllUsers(String username, String password) {
//
//        Session s = getSession();
//        Transaction tx = s.beginTransaction();
//        Criteria l = s.createCriteria(LanguagesEntity.class);
//
//
//        tx.commit();
//        s.close();
//        return (ArrayList<UsersEntity>) l.list();
//    }


//    public boolean checkUserLogin (Model model, String username, String password) {
//
//        Session s = getSession();
//        Transaction tx = s.beginTransaction();
//        UsersEntity temp = (UsersEntity) s.get(UsersEntity.class, username);
//
//        Criteria c = s.createCriteria(UsersEntity.class);
//
//        ArrayList<UsersEntity> checkuserarray = (ArrayList<UsersEntity>) c.list();
////
////        if(c.add(Restrictions.like("userName", userName))){
////            return true;
////        }
//        //return false;
//
//        model.addAttribute("username", temp.getUserName());
//
////        while (rs.next()) {
////            databaseUsername = rs.getString("users_name");
////            databasePassword = rs.getString("users_password");
////        }
////
////        if (name.equals(databaseUsername) && password.equals(databasePassword)) {
////            System.out.println("Successful Login!\n----");
////        } else {
////            System.out.println("Incorrect Password\n----");
////        }
//
//        return false;
