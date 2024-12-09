package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String askIban() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un IBAN");
        String iban = scanner.nextLine();
        return iban;
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


    public void customerAccounts(String nif, Account[] accounts) {
        for (Account account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                account.showInfo();
            }
        }
    }

    public void changeBalance(String iban, double saldo) {
        Account account = findAccount(iban, accounts);
        if (account.getIban().equals("No existe")) {
            System.out.println("No existe esa cuenta");

        } else {
            account.deposit(iban, saldo);
            System.out.println("Saldo : " + account.getSaldo());
        }
    }

    public int hasAccounts(String nif, Account[] accounts) {
        int cont = 0;
        for (Account account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                cont += 1;
            }
        }
        return cont;
    }

    public Customer data(String iban, Account[] accounts) {
        Customer data;
        for (var account : accounts) {
            if (account.getIban().equals(iban)) {
                data = account.getCustomer();
                return data;
            }
        }
        return null;
    }

    public void transferency(Account[] accounts) {
        System.out.println("Cuenta de origen");
        Account originAccount = findAccount(askIban(), accounts);
        System.out.println("Cuenta destino");
        Account finalAccount = findAccount(askIban(), accounts);
        if (originAccount == null) {
            System.out.println("La cuenta de origen no existe");
        } else if (finalAccount == null) {
            System.out.println("La cuenta final no existe");
        }

        double amount = amount();
        if (amount > originAccount.getSaldo()) {
            System.out.println("Saldo insuficiente para la transaccion");
        } else {
            changeBalance(originAccount.getIban(), -amount);
            changeBalance(finalAccount.getIban(), amount);
        }
    }

    public double amount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un monton");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        return amount;
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
