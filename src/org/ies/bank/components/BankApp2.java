package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class BankApp2 {
    private final Scanner scanner;

    public BankApp2(Scanner scanner, AccountReader accountReader, CustomerReader customerReader) {
        this.scanner = scanner;
    }

    public void run(Bank bank) {
        int select;
        do {
            System.out.println("1.Mostrar las cuentas del banco");
            System.out.println("2.Mostrar datos de una cuenta");
            System.out.println("3.Mostrar los datos de las cuentas de un cliente");
            System.out.println("4.Ingresar dinero en cuenta");
            System.out.println("5.Sacar dinero de una cuenta");
            System.out.println("6.Hacer una transferencia");
            System.out.println("7.Salir");
            select = scanner.nextInt();
            scanner.nextLine();
            if (select == 1) {
                bank.showAllAccounts(bank.getAccounts());
            } else if (select == 2) {;
                bank.showAccount(bank.askIban(), bank.getAccounts());
            } else if (select == 3) {
                System.out.println("Introduce el nif");
                String nif = scanner.nextLine();
                bank.customerAccounts(nif, bank.getAccounts());
            } else if (select == 4) {
                bank.changeBalance(bank.askIban(), bank.amount());
            } else if (select == 5) {
                bank.changeBalance(bank.askIban(), bank.amount());
            } else if (select == 6) {
                bank.transferency(bank.getAccounts());
            }
            else if (select == 7){
                System.out.println("Saliendo de la aplicacion del banco...");
            }
            else {
                System.out.println("Opcion no valida");
            }
        } while (select != 7);
    }
}
