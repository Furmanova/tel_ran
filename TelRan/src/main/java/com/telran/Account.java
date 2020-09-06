package com.telran;

import java.util.Objects;

public class Account {
    private String id;
    private Long balance;
    private boolean isLocked;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return isLocked == account.isLocked &&
                Objects.equals(id, account.id) &&
                Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, isLocked);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                ", isLocked=" + isLocked +
                '}';
    }

    public Account(String id, Long balance, boolean isLocked) {
        this.id = id;
        this.balance = balance;
        this.isLocked = isLocked;
    }

    public String getId() {
        return id;
    }

    public Long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
