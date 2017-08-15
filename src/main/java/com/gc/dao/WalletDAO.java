package com.gc.dao;

import com.gc.models.WalletEntity;


public interface WalletDAO {
    Integer save(WalletEntity newWallet);

    int getWallet(int userId);

    void deleteWalletID(int walletID);

    void creditToWallet(int credit, int walletID);

    void debitFromWallet(int debit, int walletID);

}
