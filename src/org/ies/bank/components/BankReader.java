package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankReader {
    private final Scanner scanner;
    private final AccountReader accountReader;

    public BankReader(Scanner scanner, AccountReader accountReader) {
        this.scanner = scanner;
        this.accountReader = accountReader;
    }

    public Bank bankReader(){
        System.out.println("Introduce los datos del banco");
        System.out.println("Nombre del banco");
        String name = scanner.nextLine();
        System.out.println("Cuantas cuentas tiene");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Los datos de la cuenta");
        Account[] accounts= new Account[size];
        for (int i = 0; i < size; i++) {
            Account account = accountReader.reader();
        }

        return new Bank(
                name,
                accounts
        );
    }
}
