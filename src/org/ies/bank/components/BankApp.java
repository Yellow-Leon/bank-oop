package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;

    public BankApp(Scanner scanner, AccountReader accountReader, CustomerReader customerReader) {
        this.scanner = scanner;
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
            select = scanner.nextInt();
            scanner.nextLine();
            if (select == 1) {
                bank.showAllAccounts(bank.getAccounts());
            } else if (select == 2) {
                System.out.println("Introduce el IBAN de la cuenta a buscar");
                String iban = scanner.nextLine();
                bank.showAccount(iban, bank.getAccounts());
            } else if (select == 3) {
                String nif = scanner.nextLine();
                bank.customerAccounts(nif, bank.getAccounts());
            } else if (select == 4) {
                System.out.println("Introduce el IBAN de la cuenta");
                String iban = scanner.nextLine();
                System.out.println("¿Cuanto dinero depositara?");
                double saldo = scanner.nextDouble();
                scanner.nextLine();
                bank.inputSaldo(iban, saldo);
            } else if (select == 5) {
                System.out.println("Introduce el IBAN de la cuenta");
                String iban = scanner.nextLine();
                System.out.println("¿Cuanto dinero retirara?");
                double saldo = scanner.nextDouble();
                scanner.nextLine();
                bank.outputSaldo(iban, saldo);
            } else if (select == 6) {
                System.out.println("Saliendo de la aplicacion del banco...");
            }
        } while (select != 6);
    }
}
