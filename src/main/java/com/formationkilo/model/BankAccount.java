package com.formationkilo.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class BankAccount {

    private String idAccount=UUID.randomUUID().toString();

    public BankAccount() {
    }

    public BankAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }
}
