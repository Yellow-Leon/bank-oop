package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;
    private final AccountReader accountReader;
    private final CustomerReader customerReader;

    public BankApp(Scanner scanner, AccountReader accountReader, CustomerReader customerReader) {
        this.scanner = scanner;
        this.accountReader = accountReader;
        this.customerReader = customerReader;
    }

    public void menu(Bank bank) {
        int select;
        do {
            System.out.println("1.Mostrar las cuentas del banco");
            System.out.println("2.Mostrar datos de una cuenta");
            System.out.println("3.Mostrar los datos de las cuentas de un cliente");
            System.out.println("4.Ingresar dinero en cuenta");
            System.out.println("5.Sacar dinero de una cuenta");
            System.out.println("6.Salir");
            select = option();
            if (select == 1) {
                accountPrint(bank.getAccounts());
            } else if (select == 2) {
                String iban = scanner.nextLine();
                showAccount(bank.getAccounts(), iban);
            } else if (select == 3) {

            } else if (select == 4) {

            } else if (select == 5) {

            }
        } while (select != 6);
    }

    public int option() {
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public static void accountPrint(Account[] accounts) {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public static void showAccount(Account[] accounts, String iban) {
        for (Account account : accounts) {
            if (account.getIban().equals(iban)) {
                System.out.println(account);
            }
            else{
                System.out.println("No existe la cuenta");
            }
        }
    }

    public static void customerAccounts (Account[] accounts, String nif){
        for (Account account: accounts){
            if (account.getCustomer().getNif().equals(nif)){
                System.out.println("Las cuentas del cliente son");
                System.out.println(account);
            }
        }
    }

    public void inputSaldo (Account[] accounts, String iban, double saldo){
        for (Account account: accounts){
            if (account.getIban().equals(iban)){
                account.setSaldo(account.getSaldo()+saldo);
            }
        }
    }

    public void outputSaldo (Account[] accounts, String iban, double saldo){
        for (Account account: accounts){
        }
    }
}
