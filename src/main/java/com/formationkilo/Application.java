package com.formationkilo;

import com.formationkilo.business.BankAccountService;
import com.formationkilo.business.BankAccountServiceImpl;
import com.formationkilo.exceptions.AccountNotFoundException;
import com.formationkilo.model.BankAccount;
import com.formationkilo.model.CurrentAccount;
import com.formationkilo.model.SavingAccount;
import com.formationkilo.utils.DataTransformationUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

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

        //5th option
        allAccounts.forEach(System.out::println);


        BankAccount bankAccount3=new CurrentAccount();
        bankAccount3.setIdAccount("CC1");
        bankAccountService.addBanAccount(bankAccount3);

        try {
            BankAccount accountById3=bankAccountService.getAccountById("CC3");
            System.out.println(accountById3.toString());
        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        System.out.println("APP CONTINUE AND NEVER STOP EVEN THOUGH EXCEPTION IS CAPTURED ABOVE");

        //6th option
        allAccounts.forEach(account->System.out.println(DataTransformationUtils.toJson(account)));

        //7th option
        bankAccountService.getAllAccounts().stream().map(
                acc->DataTransformationUtils.toJson(acc)
        ).forEach(System.out::println);

        //8th option
        bankAccountService.getAllAccounts().stream().map
                (DataTransformationUtils::toJson).forEach(System.out::println);

    }

    // first option above  can be replaced as followed:
        /*for (int i=0;i<allAccounts.size();i++){
            System.out.println(allAccounts.get(i).toString());
        }*/
    //Stream<BankAccount>bankAccountStream=allAccounts.stream().filter(acc->acc.getIdAccount().equals(id));


}
