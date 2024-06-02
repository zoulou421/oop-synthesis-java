package com.formationkilo.business;

import com.formationkilo.exceptions.AccountNotFoundException;
import com.formationkilo.model.BankAccount;
import com.formationkilo.model.CurrentAccount;
import com.formationkilo.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;

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
    public BankAccount getAccountById(String Id) throws AccountNotFoundException {
       /* first: Imperative approach
       for(BankAccount bankAccount:bankAccountList){
            if(bankAccount.getIdAccount().equals(Id)){
                return bankAccount;
            }
        }
          // throw new RuntimeException("BankAccount not found"); replace with:
        throw new AccountNotFoundException("BankAccount not found");

        */
        //second:Declarative approach/based on functionnal programming
        return bankAccountList
                .stream()
                .filter(acc->acc.getIdAccount().equals(Id))
                .findFirst()
                .orElseThrow(()->new AccountNotFoundException("BankAccount not found"));



    }

    @Override
    public void addRandomData(int size) {
        //AccountStatus[]values=AccountStatus.values();
        Random random=new Random();
        for(int i=0;i<size;i++){
            BankAccount bankAccount;
            if(Math.random()>0.5){
               // bankAccount=new CurrentAccount(Math.random()>0.5?"EUR":"USB",Math.random()*1000000,Math.random()*500000);
                bankAccount=new CurrentAccount();
               // bankAccount.setStatus(values[random.nextInt(values.length)]);
            }else{
                bankAccount=new SavingAccount();
            }
        }

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

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> myFilter) {
        List<BankAccount>result=new ArrayList<>();
        for(BankAccount acc:bankAccountList){
            if(myFilter.test(acc)){
                result.add(acc);
            }
        }
        return result;
    }
}
