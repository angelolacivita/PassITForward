package com.gc.dao;

import com.gc.dto.passITforwardDTO;

import java.util.List;

/**
 * Created by maurice on 7/20/17.
 * Concrete DAO implementation for JDBC Database connections
 */
public class JDBCDao implements passITforwardDAO {
    @Override
    public List<passITforwardDTO> read() {
        //TODO
        return null;
    }

    @Override
    public void addProduct(passITforwardDTO product) {
        //TODO
    }

    @Override
    public void deleteProduct(int keyIndex) {
        //TODO
    }

    @Override
    public void updateProduct(int keyIndex, passITforwardDTO product) {
        //TODO
    }
}
