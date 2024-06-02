package com.formationkilo.business;

import com.formationkilo.model.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccountServiceImpl implements BankAccountService{
   // private List bankAccounts=new ArrayList<>();less than java 5, only objects,not precized
    //private List<BankAccount> bankAccounts=new ArrayList<BankAccount>();//by java 5 and plus:generic collection
    //OR
    private List<BankAccount> bankAccountList=new ArrayList<>();//generic collection


    @Override
    public BankAccount addBanAccount(BankAccount account) {
        bankAccountList.add(account);
        return account;
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return bankAccountList;
    }

    /*
    @Override
    public BankAccount getAccountById(String Id) {
        for(BankAccount bankAccount:bankAccountList){
            if(bankAccount.getIdAccount().equals(Id)){
                return bankAccount;
            }
        }
        return null;
    }
     */
    @Override
    public BankAccount getAccountById(String Id) {
        for(BankAccount bankAccount:bankAccountList){
            if(bankAccount.getIdAccount().equals(Id)){
                return bankAccount;
            }
        }
            throw new RuntimeException("BankAccount not found");

    }

    @Override
    public void addRandomData(int size) {

    }

    @Override
    public void credit(String accountId, double amount) {

    }

    @Override
    public void debit(String accountId, double amount) {

    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount) {

    }
}
