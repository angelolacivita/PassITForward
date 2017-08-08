package com.gc.models;

import javax.persistence.*;

/**
 * Created by angelo on 8/8/17.
 */
@Entity
@Table(name = "wallet", schema = "PassITForward", catalog = "")
public class WalletEntity {
    private int walletId;
    private int walletValue;
    private int userId;

    @Id
    @Column(name = "walletID", nullable = false)
    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    @Basic
    @Column(name = "walletValue", nullable = false)
    public int getWalletValue() {
        return walletValue;
    }

    public void setWalletValue(int walletValue) {
        this.walletValue = walletValue;
    }

    @Basic
    @Column(name = "userID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WalletEntity that = (WalletEntity) o;

        if (walletId != that.walletId) return false;
        if (walletValue != that.walletValue) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = walletId;
        result = 31 * result + walletValue;
        result = 31 * result + userId;
        return result;
    }
}
