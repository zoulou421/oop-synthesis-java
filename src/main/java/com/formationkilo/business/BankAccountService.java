package com.formationkilo.business;

import com.formationkilo.model.BankAccount;

import java.util.List;

public interface BankAccountService {
    //void addBanAccount(BankAccount account);
    BankAccount addBanAccount(BankAccount account);
    List<BankAccount> getAllAccounts();
    BankAccount getAccountById(String Id);
    void addRandomData(int size);
    void credit(String accountId, double amount);
    void debit(String accountId, double amount);
    void transfer(String accountSource, String accountDestination, double amount);
}
/*
public abstract class BackAccountService {
    public abstract void addBanAccount(BankAccount account);
    public abstract List<BankAccount> getAllAccounts();*/

