package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public void showAllAccounts(Account[] accounts) {
        for (Account account : accounts) {
            System.out.println("IBAN: " + account.getIban() + " Saldo : " + account.getSaldo() + " Customer " + account.getCustomer());
        }
    }

    public void ShowAccount(String iban, Account[] accounts) {
        Account account = findAccount(iban, accounts);
        System.out.println(account);
        if (account == null ){
            System.out.println("No existe la cuenta");
        }
    }

    public Account findAccount(String iban, Account[] accounts) {
        for (Account account : accounts) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }

    public void customerAccounts(String nif, Account[] accounts) {
        for (Account account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                System.out.println(account);
            }
        }
    }

    public void inputSaldo(String iban, double saldo) {
        Account account = findAccount(iban, accounts);
        account.setSaldo(account.getSaldo() + saldo);
        System.out.println(account.getSaldo());
    }

    public void outputSaldo(String iban, double saldo) {
        Account account = findAccount(iban, accounts);
        account.setSaldo(account.getSaldo() - saldo);
        System.out.println("Saldo : " + account.getSaldo());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
