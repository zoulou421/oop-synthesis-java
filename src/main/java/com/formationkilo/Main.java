package com.formationkilo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.formationkilo.model.BankAccount;
import com.formationkilo.model.CurrentAccount;
import com.formationkilo.model.SavingAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("use of jar testjava-1.0-SNAPSHOT.jar ");
        List<BankAccount> myList = new ArrayList<>();
        myList.add(new CurrentAccount());
        for (BankAccount a : myList) {
            System.out.println(a.toString());
        }

        Map<String, BankAccount> myMap = new HashMap<>();
        myMap.put("cc1", new SavingAccount());
        BankAccount a2 = myMap.get("cc1");
        System.out.println(a2.toString());
        for (String key : myMap.keySet()) {
            System.out.println("by key..." + myMap.get(key));
        }

        for (BankAccount ba : myMap.values()) {
            System.out.println("by value..." + ba);
        }

        for (BankAccount ba : myMap.values()) {
            System.out.println("by value JSON FORMAT..." + toJson(ba));
        }
    }

    public static  String toJson(Object o) throws JsonProcessingException {
            ObjectMapper objectMapper=new ObjectMapper();
           // return objectMapper.writeValueAsString(o);
         return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);

    }
}