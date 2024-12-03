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

    public void showAccount(String iban, Account[] accounts) {
        Account account = findAccount(iban, accounts);
        if (account == null) {
            System.out.println("No existe la cuenta");
        }
        System.out.println(account);
    }

    public Account findAccount(String iban, Account[] accounts) {
        for (Account account : accounts) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return new Account("No existe", 0, null);
    }

    //Falta que muestre algo
    public void customerAccounts(String nif, Account[] accounts) {
        for (Account account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                System.out.println("IBAN: " + account.getIban() + " Saldo : " + account.getSaldo() + " Customer " + account.getCustomer());
            } else if (!nif.equals(account.getCustomer().getNif())) {
                System.out.println("El cliente no tiene cuentas");
            }
        }
    }

    public void inputSaldo(String iban, double saldo) {
        Account account = findAccount(iban, accounts);
        if (account.getIban().equals("No existe")) {
            System.out.println("No existe esa cuenta");
        } else {
            account.setSaldo(account.getSaldo() + saldo);
            System.out.println(account.getSaldo());
        }
    }

    public void outputSaldo(String iban, double saldo) {
        Account account = findAccount(iban, accounts);
        if (account.getIban().equals("No existe")) {
            System.out.println("No existe esa cuenta");

        } else {
            if (account.getSaldo() < saldo) {
                System.out.println("El saldo disponible es menor a la cantidad solicitada");
            } else {
                account.setSaldo(account.getSaldo() - saldo);
                System.out.println("Saldo : " + account.getSaldo());
            }
        }
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
