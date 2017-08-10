package com.gc.dao;

import com.gc.models.WalletEntity;

public interface WalletDAO {
    Integer save(WalletEntity newWallet);
    Integer getWalletID(int walletID);
    void deleteWalletID(int walletID);
    void creditToWallet(int credit, int walletID);
    void debitFromWallet(int debit, int walletID);

}
