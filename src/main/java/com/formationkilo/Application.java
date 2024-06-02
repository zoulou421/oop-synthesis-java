package com.formationkilo;

import com.formationkilo.business.BankAccountService;
import com.formationkilo.business.BankAccountServiceImpl;
import com.formationkilo.model.BankAccount;
import com.formationkilo.model.CurrentAccount;
import com.formationkilo.model.SavingAccount;

import java.util.List;
import java.util.function.Consumer;

public class Application {

    public static void main(String[] v){
        // BankAccountServiceImpl bankAccountService=new BankAccountServiceImpl();
         BankAccountService bankAccountService=new BankAccountServiceImpl();
         bankAccountService.addBanAccount(new CurrentAccount());
         bankAccountService.addBanAccount(new SavingAccount());

        List<BankAccount>allAccounts=bankAccountService.getAllAccounts();
        // first option
        for (int i=0;i<allAccounts.size();i++){
            System.out.println(allAccounts.get(i).toString());
        }
        //second option
        for(BankAccount bankAccount:allAccounts){
            System.out.println(bankAccount.toString());
        }

        //3rd option
        allAccounts.forEach(new Consumer<BankAccount>() {//functional interface:because contains one method
            @Override
            public void accept(BankAccount account) {
                System.out.println(account.toString());
            }
        });

        //4th option
        allAccounts.forEach(account->System.out.println(account.toString()));



    }


}
