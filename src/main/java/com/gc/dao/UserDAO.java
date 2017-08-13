package com.gc.dao;

import com.gc.models.UsersEntity;

import java.util.ArrayList;

public interface UserDAO {
    Integer save(UsersEntity newUser);
    Integer getUserID(String firstName);
    void deleteUser(int userID);
    UsersEntity getUser(String userName, String password);

    //boolean checkUser(String userName, String password);


}