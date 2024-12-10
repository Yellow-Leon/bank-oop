package org.ies.bank.model;

import java.util.Objects;

public class Account {
    private String iban;
    private double saldo;
    private Customer customer;

    public Account(String iban, double saldo, Customer customer) {
        this.iban = iban;
        this.saldo = saldo;
        this.customer = customer;
    }

    public void showInfo() {
        System.out.println("IBAN : " + iban + " Saldo : " + saldo + " Customer : " + customer);
    }

    public void deposit(String iban, double amount) {
        saldo += amount;

    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(saldo, account.saldo) == 0 && Objects.equals(iban, account.iban) && Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, saldo, customer);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", saldo=" + saldo +
                ", customer=" + customer +
                '}';
    }
}
