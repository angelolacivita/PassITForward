package com.gc.dao;

import com.gc.models.UsersEntity;

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

public interface UserDAO {
    Integer save(UsersEntity newUser);

    Integer getUserID(String firstName);

    void deleteUser(int userID);

    UsersEntity getUser(String userName, String password);

    //boolean checkUser(String userName, String password);


}