package com.gc.dao;

import com.gc.models.WalletEntity;

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
public interface WalletDAO {
    Integer save(WalletEntity newWallet);

    int getWallet(int userId);

    void deleteWalletID(int walletID);

    void creditToWallet(int credit, int walletID);

    void debitFromWallet(int debit, int walletID);

}
